import { ITodo } from './ITodo.js';

export class TodoList {
  edit(_id: string, arg1: string) {
      throw new Error("Method not implemented.");
  }
  remove(_id: string) {
      throw new Error("Method not implemented.");
  }
  add(_text: string) {
      throw new Error("Method not implemented.");
  }
  toggle(_id: string) {
      throw new Error("Method not implemented.");
  }
  todos: ITodo[] = [];

  addTodo(task: string): void {
    const todo: ITodo = {
        id: Date.now().toString(),
        task,
        completed: false,
        toggleCompleted: function (): void {
            throw new Error('Function not implemented.');
        },
        editTask: function (): void {
            throw new Error('Function not implemented.');
        },
        delete: function (): void {
            throw new Error('Function not implemented.');
        },
        getSummary: function (): string {
            throw new Error('Function not implemented.');
        },
        getStatus: function (): string {
            throw new Error('Function not implemented.');
        },
        getId: function (): number {
            throw new Error('Function not implemented.');
        },
        getTask: function (): string {
            throw new Error('Function not implemented.');
        },
        getCompleted: function (): boolean {
            throw new Error('Function not implemented.');
        },
        setCompleted: function (status: boolean): void {
            throw new Error('Function not implemented.');
        }
    };
    this.todos.push(todo);
  }

  toggleTodo(id: number): void {
    const todo = this.todos.find((t) => t.id === id.toString());
    if (todo) todo.completed = !todo.completed;
  }

  deleteTodo(id: number): void {
    this.todos = this.todos.filter((t) => t.id !== id.toString());
  }

  getSummary(p0: string): string {
    const completed = this.todos.filter((t) => t.completed).length;
    return `Completed: ${completed} / ${this.todos.length}`;
  }
}
