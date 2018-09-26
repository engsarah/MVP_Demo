package com.etisalat.foodmenuloader.ui.foodmenu;

import com.etisalat.foodmenuloader.data.AppDataManager;
import com.etisalat.foodmenuloader.data.model.Item;
import com.etisalat.foodmenuloader.ui.bases.BasePresenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Presenter class for FoodMenuFragment, it is responsible for rerieving data from
 * data sources and and passing data back to the controller
 */
public class FoodMenuPresenterImpl extends BasePresenter<FoodMenuFragmentController, FoodMenuMvpView> implements FoodMenuPresenterInt {

    AppDataManager mDataManager;
    FoodMenuMvpView fragmentView;
    FoodMenuFragmentController mController;

    public FoodMenuPresenterImpl(FoodMenuMvpView mView, FoodMenuFragmentController controller) {
        super(mView, controller);
        fragmentView = mView;
        mController = controller;
    }

    @Override
    public void getMenuItems() {

        mController.showProgress();
        mDataManager = new AppDataManager(this);
        mDataManager.getMenuItems();
    }

    /**
     * Callback Method to handle successful data retrival
     * @param menuItems
     */
    @Override
    public void onSuccess(List<Item> menuItems) {
        mController.hideProgress();
        if (menuItems.size() > 0) {
            Collections.sort(menuItems, new Comparator<Item>() {
                @Override
                public int compare(final Item object1, final Item object2) {
                    return object1.getName().compareTo(object2.getName());
                }
            });
        }
        mController.displayFoodMenuItems(menuItems);

        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        mController.updateToolbarTitle("last updated at: "+ timeStamp);
    }

    /**
     * Handle Errors While Retrieving data
     * @param errorMessage
     */
    @Override
    public void onFailure(String errorMessage) {
        mController.hideProgress();
        mController.displayErrorMessage(errorMessage);
    }

}
