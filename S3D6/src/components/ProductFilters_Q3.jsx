import { useState, useEffect } from 'react';

export default function ProductFilters({ onFilter }) {
  const [search, setSearch] = useState('');
  const [category, setCategory] = useState('all');
  const [priceRange, setPriceRange] = useState([0, 1000]);

  useEffect(() => {
    const timer = setTimeout(() => {
      onFilter({ search, category, priceRange });
    }, 300);

    return () => clearTimeout(timer);
  }, [search, category, priceRange]);

  return (
    <div className="filters">
      <input
        type="text"
        placeholder="Search products..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />

      <select value={category} onChange={(e) => setCategory(e.target.value)}>
        <option value="all">All Categories</option>
        <option value="electronics">Electronics</option>
        <option value="jewelery">Jewelery</option>
        <option value="men's clothing">Men's Clothing</option>
        <option value="women's clothing">Women's Clothing</option>
      </select>

      <div className="price-range">
        <span>Price: ${priceRange[0]} - ${priceRange[1]}</span>
        <input
          type="range"
          min="0"
          max="1000"
          value={priceRange[1]}
          onChange={(e) => setPriceRange([priceRange[0], e.target.value])}
        />
      </div>
    </div>
  );
}