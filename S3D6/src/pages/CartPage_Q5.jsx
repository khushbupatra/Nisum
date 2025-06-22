import { useCart } from '../context/CartContext_Q5';

export default function CartPage() {
  const {
    items,
    cartTotal,
    removeFromCart,
    clearCart,
    incrementQuantity,
    decrementQuantity,
    loading
  } = useCart();

  return (
    <div className="cart-page">
      <h1>Your Cart</h1>

      {items.length === 0 ? (
        <p>Your cart is empty</p>
      ) : (
        <>
          <div className="cart-items">
            {items.map(item => (
              <div key={item.id} className="cart-item">
                <img src={item.image} alt={item.title} />
                <div className="cart-item-info">
                  <h3>{item.title}</h3>
                  <p>${item.price.toFixed(2)}</p>
                </div>
                <div className="quantity-controls">
                  <button
                    onClick={() => decrementQuantity(item.id)}
                    disabled={item.quantity <= 1 || loading}
                  >
                    -
                  </button>
                  <span>{item.quantity}</span>
                  <button
                    onClick={() => incrementQuantity(item.id)}
                    disabled={loading}
                  >
                    +
                  </button>
                </div>
                <button
                  onClick={() => removeFromCart(item.id)}
                  disabled={loading}
                >
                  Remove
                </button>
              </div>
            ))}
          </div>

          <div className="cart-summary">
            <h3>Total: ${cartTotal.toFixed(2)}</h3>
            <button
              onClick={clearCart}
              disabled={loading}
            >
              Clear Cart
            </button>
          </div>
        </>
      )}
    </div>
  );
}