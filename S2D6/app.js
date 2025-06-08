import { saveTodos, loadTodos } from './storage.js';

class Todo {
  constructor(text) {
    this.id = Date.now().toString() + Math.random().toString(36).slice(2, 7);
    this.text = text;
    this.completed = false;
  }
}

class TodoList {
  constructor() {
    this.todos = new Map();
    const loaded = loadTodos();
    loaded.forEach(obj => {
      const todo = new Todo(obj.text);
      todo.id = obj.id;
      todo.completed = obj.completed;
      this.todos.set(todo.id, todo);
    });
  }
  add(text) {
    const todo = new Todo(text);
    this.todos.set(todo.id, todo);
    this.save();
    return todo;
  }
  remove(id) {
    this.todos.delete(id);
    this.save();
  }
  toggle(id) {
    const todo = this.todos.get(id);
    if (todo) todo.completed = !todo.completed;
    this.save();
  }
  edit(id, newText) {
    const todo = this.todos.get(id);
    if (todo) todo.text = newText;
    this.save();
  }
  *[Symbol.iterator]() {
    for (const todo of this.todos.values()) {
      yield todo;
    }
  }
  toArray() {
    return Array.from(this.todos.values());
  }
  save() {
    saveTodos(this.toArray());
  }
}

const todoList = new TodoList();
const input = document.getElementById('todo-input');
const addBtn = document.getElementById('add-btn');
const listEl = document.getElementById('todo-list');
const summaryEl = document.getElementById('summary');

function render() {
  listEl.innerHTML = '';
  for (const todo of todoList) {
    const li = document.createElement('li');
    li.className = 'todo-item' + (todo.completed ? ' completed' : '');
    li.innerHTML = `
      <div>
        <input type="checkbox" ${todo.completed ? 'checked' : ''} data-id="${todo.id}" class="complete-checkbox">
        <span class="todo-text">${todo.text}</span>
      </div>
      <div class="todo-actions">
        <button class="action-btn edit" data-id="${todo.id}">Edit</button>
        <button class="action-btn delete" data-id="${todo.id}">Delete</button>
      </div>
    `;
    listEl.appendChild(li);
  }
  updateSummary();
}

function updateSummary() {
  const arr = todoList.toArray();
  const completed = arr.filter(t => t.completed).length;
  const uncompleted = arr.length - completed;
  summaryEl.textContent = `Completed: ${completed} | Uncompleted: ${uncompleted}`;
}

addBtn.addEventListener('click', () => {
  const text = input.value.trim();
  if (text) {
    todoList.add(text);
    input.value = '';
    render();
  }
});

input.addEventListener('keydown', e => {
  if (e.key === 'Enter') addBtn.click();
});

listEl.addEventListener('click', e => {
  const id = e.target.dataset.id;
  if (e.target.classList.contains('delete')) {
    todoList.remove(id);
    render();
  } else if (e.target.classList.contains('edit')) {
    const current = todoList.todos.get(id);
    const newText = prompt('Edit task:', current.text);
    if (newText !== null && newText.trim() !== '') {
      todoList.edit(id, newText.trim());
      render();
    }
  }
});

listEl.addEventListener('change', e => {
  if (e.target.classList.contains('complete-checkbox')) {
    const id = e.target.dataset.id;
    todoList.toggle(id);
    render();
  }
});

render();
