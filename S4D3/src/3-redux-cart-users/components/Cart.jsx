import { useSelector } from 'react-redux';

export default function Cart() {
  const cart = useSelector(state => state.cart);

  return (
    <div>
      <h2>Cart ({cart.length} items)</h2>
      <ul>
        {cart.map(item => (
          <li key={item.id}>{item.name} - ${item.price}</li>
        ))}
      </ul>
    </div>
  );
}
