package com.etisalat.foodmenuloader.ui.bases;

import com.etisalat.foodmenuloader.data.model.Item;

import java.util.List;

public interface BaseControllerListener {


    public void onSuccess(List<Item> itemList);
    public void onFailure(String errorMessage);
}
