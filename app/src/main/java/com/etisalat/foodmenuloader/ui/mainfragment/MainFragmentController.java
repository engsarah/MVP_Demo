package com.etisalat.foodmenuloader.ui.mainfragment;

import com.etisalat.foodmenuloader.ui.bases.BaseController;

/**
 * MAinFragment Controller class, every UI Class including
 * Fragments or Activities should have its own controller
 */
public class MainFragmentController extends BaseController<MainFragmentPresenterImpl>{


    MainFragmentPresenterImpl menuPresenter;
    MainFragmentMvpView menuFragment;

    public MainFragmentController(MainFragmentPresenterImpl listener, MainFragmentMvpView mView) {

        super(listener);
        menuPresenter = listener;
        menuFragment = mView;
    }


}
