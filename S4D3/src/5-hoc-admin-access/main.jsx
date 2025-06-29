import React from 'react'
import ReactDOM from 'react-dom/client'
import ProductEdit from './components/ProductEdit'


const App = () => {
  return (
    <UserProvider>
      <div style={{ padding: '20px' }}>
        <h1>Product Management</h1>
        <UserControls />
        <hr />
        <ProductEdit />
      </div>
    </UserProvider>
  )
}

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
)