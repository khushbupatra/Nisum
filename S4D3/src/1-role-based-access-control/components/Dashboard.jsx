import { useContext } from 'react';
import { UserContext } from '../context/UserContext';

export default function Dashboard() {
  const { user, login, logout } = useContext(UserContext);

  const handleAdminLogin = () => {
    login({ id: 1, name: 'Admin', role: 'admin' });
  };

  const handleUserLogin = () => {
    login({ id: 2, name: 'User', role: 'user' });
  };

  return (
    <div>
      {!user.isLoggedIn ? (
        <div>
          <button onClick={handleAdminLogin}>Login as Admin</button>
          <button onClick={handleUserLogin}>Login as User</button>
        </div>
      ) : (
        <div>
          <h2>Welcome, {user.name}</h2>
          {user.role === 'admin' && (
            <div>
              <h3>Admin Panel</h3>
              <button>Add Product</button>
            </div>
          )}
          <button onClick={logout}>Logout</button>
        </div>
      )}
    </div>
  );
}