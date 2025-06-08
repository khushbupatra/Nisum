export type TodoId = string;
export type TodoStatus = "active" | "completed";
export type Maybe<T> = T | null | undefined;
export type StatusOrNever = TodoStatus | never;
