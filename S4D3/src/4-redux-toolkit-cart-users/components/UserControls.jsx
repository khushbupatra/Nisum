import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { login, logout } from '../store/store';
import { addToCart } from '../store/store';

const mockProduct = {
  id: 1,
  name: 'key pad',
  price: 1599,
};

const mockUser = {
  id: 101,
  name: 'khushbu patra',
  email: 'khushbupatra@gmail.com',
};

const UserControls = () => {
  const dispatch = useDispatch();
  const isLoggedIn = useSelector((state) => state.user.isLoggedIn);
  const userData = useSelector((state) => state.user.userData);

  const handleLogin = () => dispatch(login(mockUser));
  const handleLogout = () => dispatch(logout());
  const handleAddToCart = () => dispatch(addToCart(mockProduct));

  return (
    <div className="user-controls">
      <h2>User Controls</h2>
      {isLoggedIn ? (
        <>
          <p>Welcome, {userData?.name}</p>
          <button onClick={handleLogout}>Logout</button>
        </>
      ) : (
        <button onClick={handleLogin}>Login</button>
      )}
      <button onClick={handleAddToCart}>Add Product to Cart</button>
    </div>
  );
};

export default UserControls;