package com.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    private NumberAscOrder<Double> cut;

    @Mock CalculableStrategy<Double> calculableStrategy;
    @Mock CustomStack<Double> stack;

    @BeforeEach
    public void setup() {
        stack = new CustomStack<>(6, calculableStrategy);
        cut = new NumberAscOrder<Double>(stack);
    }

    @Test
    public void shouldSort() throws StackEmptyException, StackFullException{
        var expected = List.of(Math.random(), Math.random(), Math.random(), Math.random(), Math.random(), Math.random());

        for(int i = 0; i < expected.size(); i ++){
            when(calculableStrategy.calculateValue(Mockito.anyDouble()))
                .thenReturn(expected.get(i));
            
            stack.push(expected.get(i));
        }

        var actual = cut.sort();

        assertEquals(expected.stream().sorted().toList(), actual);
    }

    @Test
    public void shouldThrowWhenEmpty() throws StackEmptyException, StackFullException{
        assertThrows(StackEmptyException.class, () -> {
            cut.sort();
        });
    }
}