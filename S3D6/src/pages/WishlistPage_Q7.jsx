import { useWishlist } from '../hooks/useWishlist_Q7';
import ProductCard_Q3 from '../components/ProductCard_Q3';

export default function WishlistPage() {
  const { wishlist } = useWishlist();

  return (
    <div className="wishlist-page">
      <h1>Your Wishlist</h1>

      {wishlist.length === 0 ? (
        <p>Your wishlist is empty</p>
      ) : (
        <div className="wishlist-grid">
          {wishlist.map(product => (
            <ProductCard_Q3 key={product.id} product={product} />
          ))}
        </div>
      )}
    </div>
  );
}