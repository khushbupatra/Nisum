import { useEffect, useState, useRef } from 'react';

export function useInfiniteScroll(loadMore, hasMore) {
  const [isLoading, setIsLoading] = useState(false);
  const observerRef = useRef();
  const lastItemRef = useRef();

  useEffect(() => {
    if (isLoading || !hasMore) return;

    const observer = new IntersectionObserver(
      ([entry]) => {
        if (entry.isIntersecting) {
          setIsLoading(true);
          loadMore().finally(() => setIsLoading(false));
        }
      },
      { threshold: 0.1 }
    );

    if (lastItemRef.current) {
      observer.observe(lastItemRef.current);
    }

    return () => {
      if (lastItemRef.current) {
        observer.unobserve(lastItemRef.current);
      }
    };
  }, [isLoading, hasMore, loadMore]);

  return { lastItemRef, isLoading };
}