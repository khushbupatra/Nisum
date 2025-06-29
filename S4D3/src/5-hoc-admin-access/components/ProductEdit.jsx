function ProductEdit() {
  return <div>Admin-only product editor</div>;
}

export default withAdminAccess(ProductEdit);