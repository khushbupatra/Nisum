import { useContext } from 'react';
import { ThemeContext } from '../context/ThemeContext';

export default function ThemeSwitcher() {
  const { toggleTheme } = useContext(ThemeContext);
  return <button onClick={toggleTheme}>Toggle Theme</button>;
}