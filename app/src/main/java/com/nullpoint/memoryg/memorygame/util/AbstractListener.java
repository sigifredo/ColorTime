package com.nullpoint.memoryg.memorygame.util;

public abstract class AbstractListener<T> {
    private T mParent;

    public AbstractListener(T parent) {
        mParent = parent;
    }

    protected T getParent() {
        return mParent;
    }
}