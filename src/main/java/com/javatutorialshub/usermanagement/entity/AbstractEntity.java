package com.javatutorialshub.usermanagement.entity;

import org.springframework.data.domain.Persistable;

public abstract class AbstractEntity<I> implements Persistable<I> {
    private boolean isNew = true;

    public void markNotNew(){
        isNew = false;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
