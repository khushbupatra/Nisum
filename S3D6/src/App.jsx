import TodoList_Q1 from './components/TodoList_Q1';
import ThemeToggle_Q2 from './components/ThemeToggle_Q2';
import CartIcon_Q5 from './components/CartIcon_Q5';
import { Link } from 'react-router-dom';
import './App.css';

export default function App() {
  return (
    <div className="app">
      <header className="app-header">
        <h1>My App</h1>
        <nav>
          <Link to="/">Home</Link>
          <Link to="/products">Products</Link>
          <Link to="/wishlist">Wishlist</Link>
          <CartIcon_Q5 />
        </nav>
        <ThemeToggle_Q2 />
      </header>

      <main>
        <section className="todo-section">
          <h2>Todo List</h2>
          <TodoList_Q1 />
        </section>
      </main>
    </div>
  );
}