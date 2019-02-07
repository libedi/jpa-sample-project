package com.libedi.demo.util;

import java.util.Optional;
import java.util.function.Consumer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * OptionalSupport class
 * <pre>
 * Java9에서 사용되는 ifPresentOrElse()를 구현
 * </pre>
 *
 * @author Sang-jun, Park
 * @param <T>
 * @since 2019. 02. 07
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalSupport<T> {

    private final Optional<T> optional;

    public static <T> OptionalSupport<T> of(final Optional<T> optional) {
        return new OptionalSupport<>(optional);
    }

    public void ifPresentOrElse(final Consumer<T> action, final Runnable emptyAction) {
        if(optional.isPresent()) {
            optional.ifPresent(action);
        }
        else {
            emptyAction.run();
        }
    }
}
