package com.etisalat.foodmenuloader.data;

import com.etisalat.foodmenuloader.data.model.Item;

import java.util.List;

/**
 * Data Manager Interface
 */
public interface DataManager {

    public void getMenuItems();
    public void onSuccess(List<Item> menuItems);
    public void onFailure(String errorMessage);

}
