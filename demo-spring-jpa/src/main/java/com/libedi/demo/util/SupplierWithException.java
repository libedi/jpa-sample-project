package com.libedi.demo.util;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * SupplierWithException functional interface
 *
 * @author Sang-jun, Park
 * @since 2019. 04. 22
 */
@FunctionalInterface
public interface SupplierWithException<T, E extends Exception> {

    T get() throws E;

    default Supplier<T> wrapper() {
        return () -> {
            try {
                return get();
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    static <T> Supplier<T> wrapper(final SupplierWithException<T, ?> supplier) {
        return Objects.requireNonNull(supplier).wrapper();
    }
}
