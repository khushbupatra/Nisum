import { TodoId } from "./types";

export interface ITodo {
  id: TodoId;
  text: string;
  completed: boolean;
}

export interface ITodoList {
  todos: ITodo[];
  add(text: string): void;
  remove(id: TodoId): void;
  toggle(id: TodoId): void;
  edit(id: TodoId, newText: string): void;
}
