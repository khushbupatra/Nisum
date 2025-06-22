import { useWishlist } from '../hooks/useWishlist_Q7';

export default function WishlistButton({ product }) {
  const { isInWishlist, addToWishlist, removeFromWishlist } = useWishlist();

  const toggleWishlist = () => {
    if (isInWishlist(product.id)) {
      removeFromWishlist(product.id);
    } else {
      addToWishlist(product);
    }
  };

  return (
    <button
      className="wishlist-button"
      onClick={toggleWishlist}
      aria-label={isInWishlist(product.id) ? "Remove from wishlist" : "Add to wishlist"}
    >
      {isInWishlist(product.id) ? '❤️' : '🤍'}
    </button>
  );
}