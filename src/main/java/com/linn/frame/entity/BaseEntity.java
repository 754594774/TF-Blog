package com.linn.frame.entity;

/**
 * Created by Administrator on 2018-02-08.
 */
public class BaseEntity {

    private boolean state;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "state=" + state +
                '}';
    }
}
