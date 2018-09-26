package com.etisalat.foodmenuloader.ui.mainfragment;

import com.etisalat.foodmenuloader.data.AppDataManager;
import com.etisalat.foodmenuloader.data.model.Item;
import com.etisalat.foodmenuloader.ui.bases.BasePresenter;

import java.util.List;

/**
 * Main Preseneter class, in this fragment no data is retrieved
 * from backend
 */

public class MainFragmentPresenterImpl extends BasePresenter<MainFragmentController, MainFragmentMvpView> implements MainFragmentPresenterInt {

    AppDataManager mDataManager;
    MainFragmentMvpView fragmentView;

    public MainFragmentPresenterImpl(MainFragmentMvpView mView, MainFragmentController controller) {
        super(mView, controller);
        fragmentView = mView;
        mDataManager = new AppDataManager(this);
    }


    @Override
    public void onSuccess(List<Item> itemList) {

    }

    @Override
    public void onFailure(String errorMessage) {

    }
}
