package com.artbook.core.util;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;

public class Preconditions {
    private static final Map<Class<?>, WeakReference<Predicate<?>>> cachedPredicates = new ConcurrentHashMap<>();

    private Preconditions() { }

    public static <T> T requireNonEmpty(T value) {
        return requireNonEmpty(value, "Value cannot be null or empty");
    }

    @SuppressWarnings("unchecked")
    public static <T> T requireNonEmpty(T value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
        Class<T> klass = (Class<T>) value.getClass();
        WeakReference<Predicate<?>> weakReference = cachedPredicates.computeIfAbsent(klass, $ -> new WeakReference<>(new ReflectiveEmptinessPredicate<T>(klass)));
        Predicate<T> predicate = (Predicate<T>) weakReference.get();
        if (predicate == null) {
            predicate = new ReflectiveEmptinessPredicate<>(klass);
            cachedPredicates.put(klass, new WeakReference<>(predicate));
        }
        if (predicate.test(value)) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    private static final class ReflectiveEmptinessPredicate<T> implements Predicate<T> {
        private final Predicate<T> predicate;

        private ReflectiveEmptinessPredicate(Class<T> klass) {
            requireNonNull(klass);

            Predicate<T> _predicate;
            try {
                Method isEmptyMethod = klass.getMethod("isEmpty");

                _predicate = t -> {
                    try {
                        Object invoked = isEmptyMethod.invoke(t);
                        return Boolean.TRUE.equals(invoked);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                };
            } catch (NoSuchMethodException e) {
                _predicate = t -> false;
            }

            this.predicate = _predicate;
        }

        @Override
        public boolean test(T t) {
            if (t == null) {
                return true;
            }
            return predicate.test(t);
        }
    }
}
