export class TodoList {
    constructor() {
        this.todos = [];
    }
    edit(_id, arg1) {
        throw new Error("Method not implemented.");
    }
    remove(_id) {
        throw new Error("Method not implemented.");
    }
    add(_text) {
        throw new Error("Method not implemented.");
    }
    toggle(_id) {
        throw new Error("Method not implemented.");
    }
    addTodo(task) {
        const todo = {
            id: Date.now().toString(),
            task,
            completed: false,
            toggleCompleted: function () {
                throw new Error('Function not implemented.');
            },
            editTask: function () {
                throw new Error('Function not implemented.');
            },
            delete: function () {
                throw new Error('Function not implemented.');
            },
            getSummary: function () {
                throw new Error('Function not implemented.');
            },
            getStatus: function () {
                throw new Error('Function not implemented.');
            },
            getId: function () {
                throw new Error('Function not implemented.');
            },
            getTask: function () {
                throw new Error('Function not implemented.');
            },
            getCompleted: function () {
                throw new Error('Function not implemented.');
            },
            setCompleted: function (status) {
                throw new Error('Function not implemented.');
            }
        };
        this.todos.push(todo);
    }
    toggleTodo(id) {
        const todo = this.todos.find((t) => t.id === id.toString());
        if (todo)
            todo.completed = !todo.completed;
    }
    deleteTodo(id) {
        this.todos = this.todos.filter((t) => t.id !== id.toString());
    }
    getSummary(p0) {
        const completed = this.todos.filter((t) => t.completed).length;
        return `Completed: ${completed} / ${this.todos.length}`;
    }
}
