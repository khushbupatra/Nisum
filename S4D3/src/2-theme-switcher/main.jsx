import React from 'react';
import ReactDOM from 'react-dom/client';
import { ThemeProvider } from './context/ThemeContext';
import ThemedPage from './components/ThemedPage';
import ThemeSwitcher from './components/ThemeSwitcher';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <ThemeProvider>
      <ThemeSwitcher />
      <ThemedPage />
    </ThemeProvider>
  </React.StrictMode>
);