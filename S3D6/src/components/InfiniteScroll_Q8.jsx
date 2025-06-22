import { useInfiniteScroll } from '../hooks/useInfiniteScroll_Q8';

export default function InfiniteScroll({ loadMore, hasMore, children }) {
  const { lastItemRef, isLoading } = useInfiniteScroll(loadMore, hasMore);

  return (
    <>
      {children}
      <div ref={lastItemRef} style={{ height: '20px' }} />
      {isLoading && <div className="loader">Loading more products...</div>}
    </>
  );
}