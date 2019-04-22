package com.libedi.demo.util;

import java.util.Objects;

/**
 * RunnableWithException functional interface
 *
 * @author Sang-jun, Park
 * @since 2019. 01. 23
 */
@FunctionalInterface
public interface RunnableWithException<E extends Exception> {

    void run() throws E;

    default Runnable wrapper() {
        return () -> {
            try {
                run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    static Runnable wrapper(final RunnableWithException<?> runnable) {
        return Objects.requireNonNull(runnable).wrapper();
    }
}
