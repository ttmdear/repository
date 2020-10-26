package com.pentacomp.ezamowienia.mo.importer.util;

import java.util.Iterator;
import java.util.function.Function;

public class PaginationFetcher<T> implements Iterator<T> {
    private Integer pageNum;
    private Integer total;
    private Function<Integer, Iterator<? extends T>> fetcher;
    private Iterator<? extends T> iterator;

    public PaginationFetcher(Iterator<? extends T> iterator, Function<Integer, Iterator<? extends T>> fetcher,
        Integer pageNum,
        Integer total) {

        this.pageNum = pageNum;
        this.total = total;
        this.iterator = iterator;
        this.fetcher = fetcher;
    }

    public static <T> PaginationFetcher<T> create(Iterator<? extends T> iterator,
        Function<Integer, Iterator<? extends T>> fetcher,
        Integer pageNum,
        Integer total) {

        return new PaginationFetcher<>(iterator, fetcher, pageNum, total);
    }

    @Override
    public boolean hasNext() {
        if (!iterator.hasNext()) {
            if (total == 0) {
                return false;
            }

            iterator = fetcher.apply(pageNum);

            return iterator.hasNext();
        }

        return true;
    }

    @Override
    public T next() {
        total--;

        return iterator.next();
    }
}
