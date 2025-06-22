import { useState, useEffect } from 'react';
import { fetchProducts } from '../api/products';

export default function ProductList() {
  const [products, setProducts] = useState([]);
  const [filteredProducts, setFilteredProducts] = useState([]);

  useEffect(() => {
    fetchProducts().then(data => {
      setProducts(data);
      setFilteredProducts(data);
    });
  }, []);

  const handleFilter = ({ search, category, priceRange }) => {
    const filtered = products.filter(product => {
      const matchesSearch = product.title.toLowerCase().includes(search.toLowerCase());
      const matchesCategory = category === 'all' || product.category === category;
      const matchesPrice = product.price >= priceRange[0] && product.price <= priceRange[1];
      return matchesSearch && matchesCategory && matchesPrice;
    });
    setFilteredProducts(filtered);
  };

  return (
    <div className="products-container">
      <ProductFilters onFilter={handleFilter} />

      <div className="product-grid">
        {filteredProducts.map(product => (
          <div key={product.id} className="product-card">
            <img src={product.image} alt={product.title} />
            <h3>{product.title}</h3>
            <p>${product.price}</p>
          </div>
        ))}
      </div>
    </div>
  );
}