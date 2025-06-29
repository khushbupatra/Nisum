import { createContext, useState } from 'react';

export const UserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState({
    id: null,
    name: '',
    role: 'guest',
    isLoggedIn: false
  });

  const login = (userData) => {
    setUser({
      id: userData.id,
      name: userData.name,
      role: userData.role,
      isLoggedIn: true
    });
  };

  const logout = () => {
    setUser({
      id: null,
      name: '',
      role: 'guest',
      isLoggedIn: false
    });
  };

  return (
    <UserContext.Provider value={{ user, login, logout }}>
      {children}
    </UserContext.Provider>
  );
};