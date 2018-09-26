package com.etisalat.foodmenuloader.ui.foodmenu;

import com.etisalat.foodmenuloader.data.model.Item;
import com.etisalat.foodmenuloader.ui.bases.BasePresenterListener;

import java.util.List;

/**
 * View interface for FoodMenuFragment, contain abstract
 * methods tht should be implemented to handle UI in different
 * cases
 */
public interface FoodMenuMvpView extends BasePresenterListener {

    public void displayFoodMenuItems(List<Item> itemList);
    public void displayErrorMessage(String errorMessage);
    public void updateToolbarTitle(String title);
}
