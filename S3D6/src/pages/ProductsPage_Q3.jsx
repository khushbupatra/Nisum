import { useState, useEffect } from 'react';
import { fetchProducts } from '../api/products';
import ProductList_Q3 from '../components/ProductList_Q3';
import ProductFilters_Q3 from '../components/ProductFilters_Q3';
import InfiniteScroll_Q8 from '../components/InfiniteScroll_Q8';

export default function ProductsPage() {
  const [products, setProducts] = useState([]);
  const [page, setPage] = useState(1);
  const [hasMore, setHasMore] = useState(true);
  const [category, setCategory] = useState('all');
  const [loading, setLoading] = useState(false);

  const loadProducts = async (reset = false) => {
    if (loading) return;

    setLoading(true);
    try {
      const newProducts = await fetchProducts(
        reset ? 1 : page,
        10,
        category === 'all' ? '' : category
      );

      if (newProducts.length === 0) {
        setHasMore(false);
      } else {
        setProducts(prev => reset ? newProducts : [...prev, ...newProducts]);
        setPage(prev => reset ? 2 : prev + 1);
      }
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    setProducts([]);
    setPage(1);
    setHasMore(true);
    loadProducts(true);
  }, [category]);

  return (
    <div className="products-page">
      <ProductFilters_Q3
        onCategoryChange={setCategory}
        currentCategory={category}
      />

      <InfiniteScroll_Q8
        loadMore={() => loadProducts(false)}
        hasMore={hasMore && !loading}
      >
        <ProductList_Q3 products={products} />
      </InfiniteScroll_Q8>
    </div>
  );
}