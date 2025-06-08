export interface ITodo {
  id: string;
  task: string;
  completed: boolean;
    toggleCompleted(): void;
    editTask(newTask: string): void;
    delete(): void;
    getSummary(): string;
    getStatus(): string;
    getId(): number;
    getTask(): string;
    getCompleted(): boolean;
    setCompleted(status: boolean): void;
}
