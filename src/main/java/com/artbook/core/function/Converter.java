package com.artbook.core.function;

import java.util.function.Function;

import static java.util.Objects.requireNonNull;

@FunctionalInterface
public interface Converter<T,U> {
    public U convert(T item) throws Exception;

    public default <V> Converter<T,V> andThen(Converter<U,V> that) {
        return item -> that.convert(this.convert(item));
    }

    public default <S> Converter<S,U> contraMap(Function<S,T> fn) {
        requireNonNull(fn);

        var self = this;
        return item -> {
            T t = fn.apply(item);
            return self.convert(t);
        };
    }

    public default U convertUnchecked(T item) {
        try {
            return convert(item);
        } catch (RuntimeException re) {
            throw re;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public default <V> Converter<T,V> map(Function<U,V> fn) {
        requireNonNull(fn);

        var self = this;
        return item -> {
            U u = self.convert(item);
            return fn.apply(u);
        };
    }
}
