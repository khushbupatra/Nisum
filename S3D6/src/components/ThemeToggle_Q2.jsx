import { useTheme } from '../context/ThemeContext_Q2';

export default function ThemeToggle() {
  const { isDark, toggleTheme } = useTheme();

  return (
    <button onClick={toggleTheme}>
      {isDark ? '☀️ Light Mode' : '🌙 Dark Mode'}
    </button>
  );
}