package com.nullpoint.memoryg.memorygame.util;

public abstract class AbstractListener<Parent> {
    private Parent mParent;

    public AbstractListener(Parent parent) {
        mParent = parent;
    }

    protected Parent getParent() {
        return mParent;
    }
}