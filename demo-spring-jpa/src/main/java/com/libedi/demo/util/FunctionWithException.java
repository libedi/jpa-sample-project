package com.libedi.demo.util;

import java.util.Objects;
import java.util.function.Function;

/**
 * FunctionWithException functional interface
 *
 * @author Sang-jun, Park
 * @since 2019. 02. 13
 */
@FunctionalInterface
public interface FunctionWithException<T, R, E extends Exception> {

    R apply(T t) throws E;

    default Function<T, R> wrapper() {
        return t -> {
            try {
                return apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    static <T, R> Function<T, R> wrapper(final FunctionWithException<T, R, ?> function) {
        return Objects.requireNonNull(function).wrapper();
    }

}
