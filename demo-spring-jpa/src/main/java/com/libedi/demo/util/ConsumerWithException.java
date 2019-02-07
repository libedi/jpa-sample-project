package com.libedi.demo.util;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * ConsumerWithException functional interface
 *
 * @author Sang-jun, Park
 * @since 2019. 01. 22
 */
@FunctionalInterface
public interface ConsumerWithException<T, E extends Exception> {

    void accept(T t) throws E;

    default Consumer<T> wrapper() {
        return t -> {
            try {
                accept(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    static <T> Consumer<T> wrapper(final ConsumerWithException<T, ?> consumer) {
        return Objects.requireNonNull(consumer).wrapper();
    }

}
