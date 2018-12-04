package com.amiggo.base;

public interface BasePresenter<V> {

    void dropView();

    void takeView(V view);

}
