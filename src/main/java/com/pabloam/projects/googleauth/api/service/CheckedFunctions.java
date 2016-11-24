package com.pabloam.projects.googleauth.api.service;

import java.io.IOException;

public class CheckedFunctions {

    @FunctionalInterface
    public interface CheckedFunction<T, R> {
        R apply(T t) throws RuntimeException, IOException;
    }

    @FunctionalInterface
    public interface CheckedBiFunction<T, U, R> {
        R apply(T t, U u) throws RuntimeException, IOException;
    }

    @FunctionalInterface
    public interface CheckedConsumer<T> {
        void apply(T t) throws RuntimeException, IOException;
    }

    @FunctionalInterface
    public interface CheckedBiConsumer<T, U> {
        void apply(T t, U u) throws RuntimeException, IOException;
    }
}
