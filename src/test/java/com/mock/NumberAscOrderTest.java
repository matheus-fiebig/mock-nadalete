package com.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {
    private NumberAscOrder<Double> numberAscOrder;

    @Mock CalculableStrategy<Double> calculableStrategy;
    @Mock CustomStack<Double> stack;

    @BeforeEach
    public void setup() {
        numberAscOrder = new NumberAscOrder<Double>(stack);
    }
}