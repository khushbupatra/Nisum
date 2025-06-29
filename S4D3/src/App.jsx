import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import './1.css';
import './2.css';
import './3.css';
import './5.css';
import './global.css';
import'./index.css';

import RoleBasedAccess from './1-role-based-access-control/Dashboard';
import ThemeSwitcherApp from './2-theme-switcher/ThemedPage';
import ReduxCartApp from './3-redux-cart-users/Cart';
import ReduxToolkitApp from './4-redux-toolkit-cart-users/Cart';
import HOCAdminApp from './5-hoc-admin-access/App';

function App() {
  const [count, setCount] = useState(0);

  return (
    <Router>
      <div className="app-container">
        <nav className="navigation">

          <ul className="nav-links">
            <li><Link to="/">Home</Link></li>
            <li><Link to="/role-access">Assignment 1</Link></li>
            <li><Link to="/theme-switcher">Assignment 2</Link></li>
            <li><Link to="/redux-cart">Assignment 3</Link></li>
            <li><Link to="/redux-toolkit">Assignment 4</Link></li>
            <li><Link to="/hoc-admin">Assignment 5</Link></li>
          </ul>

          <div className="counter">
            <button onClick={() => setCount((count) => count + 1)}>
              Visits: {count}
            </button>
          </div>
        </nav>

        <main className="content">
          <Routes>
            <Route path="/" element={
              <div className="home">
                <h1>React Assignments Showcase</h1>
                </div>
            } />
            <Route path="/role-access" element={<RoleBasedAccess />} />
            <Route path="/theme-switcher" element={<ThemeSwitcherApp />} />
            <Route path="/redux-cart" element={<ReduxCartApp />} />
            <Route path="/redux-toolkit" element={<ReduxToolkitApp />} />
            <Route path="/hoc-admin" element={<HOCAdminApp />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;