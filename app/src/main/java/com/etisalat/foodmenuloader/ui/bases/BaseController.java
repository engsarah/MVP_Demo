package com.etisalat.foodmenuloader.ui.bases;

/**
 * All Controllers should extend BaseController class
 * @param <T>
 */
public abstract class BaseController<T extends BaseControllerListener> {

    protected T listener;

    public BaseController(T listener) {
        this.listener = listener;
    }


}
