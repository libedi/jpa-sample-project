package com.libedi.demo.util;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * OptionalSupport class
 *
 * @author Sang-jun, Park
 * @param <T>
 * @since 2019. 02. 07
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalSupport<T> {

    private final Optional<T> optional;

    /**
     * Returns an {@code OptionalSupport} with the specified {@code Optional}.
     * @param optional the Object of {@code Optional}
     * @return an {@code OptionalSupport} with {@code Optional}
     */
    public static <T> OptionalSupport<T> of(final Optional<T> optional) {
        return new OptionalSupport<>(optional);
    }

    /**
     * If a value is present, performs the given action with the value,
     * otherwise performs the given empty-based action.
     *
     * @param action the action to be performed, if a value is present
     * @param emptyAction the empty-based action to be performed, if no value is present
     * @throws NullPointerException if a value is present and the given action is null,
     * or no value is present and the given empty-based action is null.
     */
    public void ifPresentOrElse(final Consumer<T> action, final Runnable emptyAction) {
        if(optional.isPresent()) {
            optional.ifPresent(action);
        }
        else {
            emptyAction.run();
        }
    }

    /**
     * If a value is present, performs the given action with the value,
     * otherwise throw an exception to be created by the provided supplier.
     *
     * @param action the action to be performed, if a value is present
     * @param exceptionSupplier The supplier which will return the exception to be thrown
     * @throws X if there is no value present
     * @throws NullPointerException if a value is present and the given action is null,
     * or no value is present and {@code exceptionSupplier} is null
     */
    public <X extends Throwable> void ifPresentOrElseThrow(final Consumer<T> action,
            final Supplier<? extends X> exceptionSupplier) throws X {
        if(optional.isPresent()) {
            optional.ifPresent(action);
        }
        else {
            exceptionSupplier.get();
        }
    }
}
