import { useReducer } from 'react';
import TodoForm_Q1 from './TodoForm_Q1';

const initialState = {
  todos: [],
};

function reducer(state, action) {
  switch (action.type) {
    case 'ADD_TODO':
      return {
        todos: [...state.todos, {
          id: Date.now(),
          text: action.payload,
          completed: false
        }]
      };
    case 'TOGGLE_TODO':
      return {
        todos: state.todos.map(todo =>
          todo.id === action.payload ? {...todo, completed: !todo.completed} : todo
        )
      };
    case 'DELETE_TODO':
      return {
        todos: state.todos.filter(todo => todo.id !== action.payload)
      };
    default:
      return state;
  }
}

export default function TodoList_Q1() {
  const [state, dispatch] = useReducer(reducer, initialState);

  const completedCount = state.todos.filter(todo => todo.completed).length;
  const pendingCount = state.todos.length - completedCount;

  return (
    <div className="todo-container">
      <h1>Todo List</h1>
      <TodoForm_Q1 dispatch={dispatch} />

      <div className="counts">
        <p>Completed: {completedCount}</p>
        <p>Pending: {pendingCount}</p>
      </div>

      <ul className="todo-list">
        {state.todos.map(todo => (
          <li key={todo.id} className={todo.completed ? 'completed' : ''}>
            <span onClick={() => dispatch({type: 'TOGGLE_TODO', payload: todo.id})}>
              {todo.text}
            </span>
            <button onClick={() => dispatch({type: 'DELETE_TODO', payload: todo.id})}>
              Delete
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}