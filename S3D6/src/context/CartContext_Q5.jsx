import { createContext, useContext, useReducer } from 'react';
import { cartReducer } from '../reducers/cartReducer_Q5';

const CartContext = createContext();

const initialState = { items: [], loading: false };

export function CartProvider({ children }) {
  const [state, dispatch] = useReducer(cartReducer, initialState);

  const addToCart = (product) => {
    dispatch({ type: 'ADD_ITEM', payload: product });
  };

  const removeFromCart = (productId) => {
    dispatch({ type: 'REMOVE_ITEM', payload: productId });
  };

  const clearCart = () => {
    dispatch({ type: 'CLEAR_CART' });
  };

  const incrementQuantity = (productId) => {
    dispatch({ type: 'INCREMENT_QUANTITY', payload: productId });
  };

  const decrementQuantity = (productId) => {
    dispatch({ type: 'DECREMENT_QUANTITY', payload: productId });
  };

  const cartTotal = state.items.reduce(
    (total, item) => total + (item.price * item.quantity), 0
  );

  return (
    <CartContext.Provider
      value={{
        items: state.items,
        cartTotal,
        loading: state.loading,
        addToCart,
        removeFromCart,
        clearCart,
        incrementQuantity,
        decrementQuantity,
      }}
    >
      {children}
    </CartContext.Provider>
  );
}

export function useCart() {
  return useContext(CartContext);
}