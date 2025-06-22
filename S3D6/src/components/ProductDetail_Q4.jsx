import { useParams, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { fetchProducts } from '../api/products';

export default function ProductDetail() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [product, setProduct] = useState(null);

  useEffect(() => {
    fetchProducts().then(data => {
      const foundProduct = data.find(p => p.id === parseInt(id));
      setProduct(foundProduct);
    });
  }, [id]);

  if (!product) return <div>Loading...</div>;

  return (
    <div className="product-detail">
      <button onClick={() => navigate(-1)}>Go Back</button>

      <div className="breadcrumb">
        <span>Home</span> &gt; <span>Products</span> &gt; <span>{product.title}</span>
      </div>

      <div className="product-content">
        <img src={product.image} alt={product.title} />
        <div className="product-info">
          <h1>{product.title}</h1>
          <p className="price">${product.price}</p>
          <p className="description">{product.description}</p>
          <p className="stock">In Stock: {product.rating.count}</p>
        </div>
      </div>
    </div>
  );
}