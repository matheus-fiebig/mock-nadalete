package com.mock;

import java.util.ArrayList;
import java.util.List;

public class NumberAscOrder<E extends Number> {
    private CustomStack<E> customStack;

    public NumberAscOrder(CustomStack<E> customStack) {
        super();
        this.customStack = customStack;
    }

    public List<E> sort() throws StackEmptyException {
        var l = new ArrayList<E>();
        if(customStack.isEmpty()){
            throw new StackEmptyException();
        }

        while(!customStack.isEmpty()){
            l.add((E)customStack.pop());
        }

        return l.stream().sorted().toList();
    }
}
