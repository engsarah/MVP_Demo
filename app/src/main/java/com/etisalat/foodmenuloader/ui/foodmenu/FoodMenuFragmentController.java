package com.etisalat.foodmenuloader.ui.foodmenu;

import com.etisalat.foodmenuloader.data.model.Item;
import com.etisalat.foodmenuloader.ui.bases.BaseController;

import java.util.List;

/**
 * FoodMenuController class, responsible for handing communication from
 * the presenter to the View to promote single responsability principle
 */
public class FoodMenuFragmentController extends BaseController<FoodMenuPresenterImpl>{


    FoodMenuPresenterImpl menuPresenter;
    FoodMenuMvpView mFragmentView;

    public FoodMenuFragmentController(FoodMenuPresenterImpl listener, FoodMenuMvpView mView) {
        super(listener);
        menuPresenter = listener;
        mFragmentView = mView;

    }

    /*
    * Callbacks to handle the progress dialogue in the view*/
    public void showProgress()
    {
        mFragmentView.showProgress();
    }
    /*
     * Callbacks to handle the progress dialogue in the view*/
    public void hideProgress()
    {
        mFragmentView.hideProgress();
    }


    /*
     * Callbacks to display list of menu items*/
    public void displayFoodMenuItems(List<Item> menuItems)
    {
        mFragmentView.displayFoodMenuItems(menuItems);
    }


    /*
     * Callbacks to */
    public void updateToolbarTitle(String timeStamp)
    {
        mFragmentView.updateToolbarTitle(timeStamp);
    }

    /*
     * Callbacks to handle backend errors*/
    public void displayErrorMessage(String errorMessage)
    {
        mFragmentView.displayErrorMessage(errorMessage);
    }



}
