package com.etisalat.foodmenuloader.ui.bases;

/**
 * This class is the base class for all Presenters
 * in the app
 * @param <T>
 * @param <E>
 */
public abstract class BasePresenter<T extends BaseController,
        E extends BasePresenterListener>
        implements BaseControllerListener {

    protected E listener;
    protected T controller;

    public BasePresenter(E listener, T controller) {
        this.listener = listener;
    }
}