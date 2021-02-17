package com.mo.importer.util;

import java.util.Iterator;
import java.util.function.Function;

import lombok.Getter;

/**
 * Generyczny mechanizm do stronicowania danych. Powstał na potrzeby importowania ogłoszeń z TED, ale można
 * go użyć również w innych przypadkach.
 * <p>
 * Podstawowym elementem jest tgz. 'fetcher' który będzie wywoływany w momencie gdy będzie potrzebne pobranie
 * kolejnej strony danych, zostanie mu też przekazany numer strony.
 *
 * @author Pentacomp Systemy Informatyczne S.A.
 */
public class PaginationFetcher<T> implements Iterator<T> {
    private final Function<Integer, Iterator<? extends T>> fetcher;
    @Getter
    private final Integer total;
    private Integer pageNum;
    private Integer left;
    private Iterator<? extends T> iterator;

    public PaginationFetcher(final Function<Integer, Iterator<? extends T>> fetcher, final Integer pageNum,
        final Integer total) {

        this.pageNum = pageNum;
        this.total = total;
        this.left = total;
        this.fetcher = fetcher;

        this.iterator = fetcher.apply(pageNum);
    }

    /**
     * Metoda tworząca.
     *
     * @param fetcher obiekt odpowiedziany za pobieranie danych.
     * @param pageNum liczba wszystkich stron
     * @param total   liczba wszystkich rekordów
     * @param <T>     obiekt stronicowany
     * @return zwraca iterator do iterowania po wszystkich rekordach
     */
    public static <T> PaginationFetcher<T> create(final Function<Integer, Iterator<? extends T>> fetcher,
        final Integer pageNum, final Integer total) {

        return new PaginationFetcher<>(fetcher, pageNum, total);
    }

    public static <E> PaginationFetcher<E> of(final Iterable<E> values, final Integer total) {
        return new PaginationFetcher<E>(pageNum -> values.iterator(), 0, total);
    }

    @Override
    public boolean hasNext() {
        if (!iterator.hasNext()) {
            if (left == 0) {
                return false;
            }

            pageNum++;

            iterator = fetcher.apply(pageNum);

            return iterator.hasNext();
        }

        return true;
    }

    @Override
    public T next() {
        left--;

        return iterator.next();
    }
}
