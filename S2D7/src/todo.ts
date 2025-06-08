import { ITodo } from "./interfaces";
import { TodoId } from "./types";

export class Todo implements ITodo {
  id: TodoId;
  text: string;
  completed: boolean;

  constructor(text: string) {
    this.id = Date.now().toString() + Math.random().toString(36).slice(2, 7);
    this.text = text;
    this.completed = false;
  }
}
