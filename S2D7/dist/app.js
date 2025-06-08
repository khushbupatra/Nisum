import { TodoList } from './todoList.js';
const todoList = new TodoList();
const input = document.getElementById('todo-input');
const addBtn = document.getElementById('add-btn');
const todoUl = document.getElementById('todo-list');
const summaryDiv = document.getElementById('summary');
function render() {
    todoUl.innerHTML = '';
    for (const todo of todoList.todos) {
        const li = document.createElement('li');
        li.className = 'todo-item';
        li.style.display = 'flex';
        li.style.justifyContent = 'space-between';
        li.style.alignItems = 'center';
        li.style.padding = '8px 12px';
        li.style.borderBottom = '1px solid #ddd';
        const span = document.createElement('span');
        span.textContent = todo.task;
        span.style.flexGrow = '1';
        span.style.cursor = 'pointer';
        span.style.textDecoration = todo.completed ? 'line-through' : 'none';
        span.addEventListener('click', () => {
            todoList.toggleTodo(Number(todo.id));
            render();
        });
        const delBtn = document.createElement('button');
        delBtn.textContent = 'Delete';
        delBtn.title = 'Delete';
        delBtn.style.border = 'none';
        delBtn.style.borderRadius = '4px';
        delBtn.style.padding = '6px 10px';
        delBtn.style.marginLeft = '10px';
        delBtn.style.background = '#e74c3c';
        delBtn.style.color = 'white';
        delBtn.style.cursor = 'pointer';
        delBtn.style.fontWeight = 'bold';
        delBtn.style.fontSize = '14px';
        delBtn.style.transition = 'transform 0.2s ease';
        delBtn.addEventListener('mouseenter', () => {
            delBtn.style.transform = 'scale(1.1)';
        });
        delBtn.addEventListener('mouseleave', () => {
            delBtn.style.transform = 'scale(1)';
        });
        delBtn.addEventListener('click', (e) => {
            e.stopPropagation();
            todoList.deleteTodo(Number(todo.id));
            render();
        });
        li.appendChild(span);
        li.appendChild(delBtn);
        todoUl.appendChild(li);
    }
    summaryDiv.textContent = todoList.getSummary('');
}
addBtn.addEventListener('click', () => {
    const task = input.value.trim();
    if (task) {
        todoList.addTodo(task);
        input.value = '';
        render();
    }
});
