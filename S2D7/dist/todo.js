export class Todo {
    constructor(text) {
        this.id = Date.now().toString() + Math.random().toString(36).slice(2, 7);
        this.text = text;
        this.completed = false;
    }
}
