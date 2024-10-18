package com.mock;

public interface CalculableStrategy<T extends Number> {
    T calculateValue(T value) throws NullPointerException;
}
