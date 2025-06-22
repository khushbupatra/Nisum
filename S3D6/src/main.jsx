import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App';
import { ThemeProvider } from './context/ThemeContext_Q2';
import { CartProvider } from './context/CartContext_Q5';
import ProductsPage_Q3 from './pages/ProductsPage_Q3';
import ProductDetail_Q4 from './pages/ProductDetail_Q4';
import CartPage_Q5 from './pages/CartPage_Q5';
import WishlistPage_Q7 from './pages/WishlistPage_Q7';
import './index.css';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <ThemeProvider>
      <CartProvider>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<App />} />
            <Route path="/products" element={<ProductsPage_Q3 />} />
            <Route path="/products/:id" element={<ProductDetail_Q4 />} />
            <Route path="/cart" element={<CartPage_Q5 />} />
            <Route path="/wishlist" element={<WishlistPage_Q7 />} />
          </Routes>
        </BrowserRouter>
      </CartProvider>
    </ThemeProvider>
  </React.StrictMode>
);