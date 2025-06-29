import { useContext } from 'react';
import { UserContext } from '../context/UserContext';

const withAdminAccess = (Component) => {
  return function WrappedComponent(props) {
    const { user } = useContext(UserContext);

    if (user.role !== 'admin') {
      return <div>Access Denied: Admin privileges required</div>;
    }

    return <Component {...props} />;
  };
};

export default withAdminAccess;