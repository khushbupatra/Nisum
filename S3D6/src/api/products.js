export async function fetchProducts(page = 1, limit = 10, category = '') {
  const url = category
    ? `https://fakestoreapi.com/products/category/${category}?limit=${limit}&page=${page}`
    : `https://fakestoreapi.com/products?limit=${limit}&page=${page}`;

  const response = await fetch(url);
  return await response.json();
}