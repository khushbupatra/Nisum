import { useContext } from 'react';
import { ThemeContext } from '../context/ThemeContext';

export default function ThemedPage() {
  const { theme } = useContext(ThemeContext);

  return (
    <div style={{
      backgroundColor: theme === 'light' ? '#fff' : '#333',
      color: theme === 'light' ? '#000' : '#fff',
      padding: '20px',
      minHeight: '100vh'
    }}>
      <h1>{theme === 'light' ? 'Light' : 'Dark'} Theme</h1>
    </div>
  );
}