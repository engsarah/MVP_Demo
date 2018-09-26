package com.etisalat.foodmenuloader;

import com.etisalat.foodmenuloader.data.model.Item;
import com.etisalat.foodmenuloader.ui.bases.BasePresenterListener;
import com.etisalat.foodmenuloader.ui.foodmenu.FoodMenuFragment;
import com.etisalat.foodmenuloader.ui.foodmenu.FoodMenuFragmentController;
import com.etisalat.foodmenuloader.ui.foodmenu.FoodMenuMvpView;
import com.etisalat.foodmenuloader.ui.foodmenu.FoodMenuPresenterImpl;
import com.etisalat.foodmenuloader.ui.foodmenu.FoodMenuPresenterInt;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FoodMenuPresenterUnitTest {

    List<Item> resultMenuItems;

    @Test
    public void testMenuItemsSortedAlphapetically()
    {
        //Create Presenter Instance
        FoodMenuPresenterImpl mPresenter = new FoodMenuPresenterImpl(null, new FoodMenuFragmentController(null, new FoodMenuMvpView() {
            @Override
            public void showProgress() {

            }

            @Override
            public void hideProgress() {

            }

            @Override
            public void displayFoodMenuItems(List<Item> itemList) {
                resultMenuItems = itemList;

            }

            @Override
            public void displayErrorMessage(String errorMessage) {

            }

            @Override
            public void updateToolbarTitle(String title) {

            }
        }));



        List<Item> unorderedMenuItems = new ArrayList<>();
        Item item1 = new Item("1", "Margherita", "10 LE", "Single cheese topping");
        Item item2 = new Item("2", "Fresh Veggie", "10 LE", "Oninon and Crisp capsicum");
        Item item3 = new Item("3", "Peppy Paneer", "10 LE", "Paneer, Crisp capsicum and Red pepper");
        Item item4 = new Item("4", "Deluxe Veggie", "10 LE", "Onion, crisp capsicum, Mashroom,Corn");

        unorderedMenuItems.add(item1);
        unorderedMenuItems.add(item2);
        unorderedMenuItems.add(item3);
        unorderedMenuItems.add(item4);

        //Call onSuccess
        mPresenter.onSuccess(unorderedMenuItems);

        //Assert the returned result
        Assert.assertEquals("Deluxe Veggie", resultMenuItems.get(0).getName());

    }

}
