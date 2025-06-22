import { useEffect, useReducer } from 'react';

const wishlistReducer = (state, action) => {
  switch (action.type) {
    case 'SET_WISHLIST':
      return action.payload;
    case 'ADD_ITEM':
      return [...state, action.payload];
    case 'REMOVE_ITEM':
      return state.filter(item => item.id !== action.payload);
    default:
      return state;
  }
};

export function useWishlist() {
  const [wishlist, dispatch] = useReducer(wishlistReducer, []);

  useEffect(() => {
    const saved = localStorage.getItem('wishlist');
    if (saved) {
      dispatch({ type: 'SET_WISHLIST', payload: JSON.parse(saved) });
    }
  }, []);

  useEffect(() => {
    localStorage.setItem('wishlist', JSON.stringify(wishlist));
  }, [wishlist]);

  const addToWishlist = (product) => {
    if (!wishlist.some(item => item.id === product.id)) {
      dispatch({ type: 'ADD_ITEM', payload: product });
    }
  };

  const removeFromWishlist = (productId) => {
    dispatch({ type: 'REMOVE_ITEM', payload: productId });
  };

  const isInWishlist = (productId) => {
    return wishlist.some(item => item.id === productId);
  };

  return { wishlist, addToWishlist, removeFromWishlist, isInWishlist };
}