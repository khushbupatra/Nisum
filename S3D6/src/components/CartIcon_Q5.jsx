import { useCart } from '../context/CartContext_Q5';
import { Link } from 'react-router-dom';

export default function CartIcon_Q5() {
  const { items } = useCart();

  return (
    <Link to="/cart" className="cart-icon">
      🛒 {items.length > 0 && <span className="cart-count">{items.length}</span>}
    </Link>
  );
}