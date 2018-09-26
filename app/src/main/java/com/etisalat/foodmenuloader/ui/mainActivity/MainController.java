package com.etisalat.foodmenuloader.ui.mainActivity;

import com.etisalat.foodmenuloader.ui.bases.BaseController;

/**
 * MainController class, its main purpose is to act as middle man
 * between the view and the presenter to promote abstraction and
 * single responsibility principle
 */
public class MainController extends BaseController<MainActivityPresenterImpl> {

    MainViewInt mainViewInt;
    MainActivityPresenterImpl mPresenter;


    public MainController(MainActivityPresenterImpl listener, MainViewInt mainViewInt) {
        super(listener);
        this.mPresenter = listener;
        this.mainViewInt = mainViewInt;
    }


}
