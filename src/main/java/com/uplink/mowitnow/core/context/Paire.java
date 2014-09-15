package com.uplink.mowitnow.core.context;

/**
 * Created by walid on 15/09/14.
 */
public class Paire<T , S> {

    private T leftElement;

    private S rightElement;

    public Paire(T leftElement, S rightElement) {
        this.leftElement = leftElement;
        this.rightElement = rightElement;
    }

    public T getLeftElement() {
        return leftElement;
    }

    public S getRightElement() {
        return rightElement;
    }
}
