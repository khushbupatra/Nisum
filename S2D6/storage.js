export function saveTodos(todoArray) {
  localStorage.setItem('todos', JSON.stringify(todoArray));
}

export function loadTodos() {
  const data = localStorage.getItem('todos');
  if (!data) return [];
  return JSON.parse(data);
}
