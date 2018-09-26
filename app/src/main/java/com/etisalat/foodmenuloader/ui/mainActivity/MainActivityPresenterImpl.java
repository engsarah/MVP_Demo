package com.etisalat.foodmenuloader.ui.mainActivity;

import com.etisalat.foodmenuloader.data.AppDataManager;
import com.etisalat.foodmenuloader.data.DataManager;
import com.etisalat.foodmenuloader.data.model.Item;
import com.etisalat.foodmenuloader.ui.bases.BasePresenter;

import java.util.List;

/**
 * MainPresenter class for the Main Activity
 * No Network calls are hand here
 * No data manipulation is needed.
 */
public class MainActivityPresenterImpl extends BasePresenter<MainController, MainViewInt> implements MainPresenterInt {

    private MainViewInt mView;
    private DataManager mDataManager;
    private MainController mController;

    public MainActivityPresenterImpl(MainViewInt view, MainController controller) {
        super(view, controller);
        mView = view;
        mDataManager = new AppDataManager(this);

    }


    @Override
    public void onSuccess(List<Item> itemList) {

    }

    @Override
    public void onFailure(String errorMessage) {

    }
}
