package com.etisalat.foodmenuloader.data.model;

import com.etisalat.foodmenuloader.data.db.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper class that is used to convert between list of items
 * retrieved from databse and items list for the recycler view
 * and vice vers
 */
public final class Mapper {

    public static List<Item> convertItemModelList(List<ItemModel> recievedItems) {

        List<Item> itemsList = new ArrayList<>();
        for (int i=0; i< recievedItems.size();i++) {

            ItemModel currentItem = recievedItems.get(i);
            itemsList.add(new Item(String.valueOf(currentItem.getId()),currentItem.getName()
                    , currentItem.getDescription(), currentItem.getCost()));
        }
        return itemsList;

    }

    public static List<ItemModel> convertItemsList(List<Item> recievedItems) {
        List<ItemModel> itemsList = new ArrayList<>();
        for (int i=0; i< recievedItems.size();i++) {

            Item currentItem = recievedItems.get(i);
            itemsList.add(new ItemModel(Integer.parseInt(currentItem.getId()),currentItem.getName()
                    , currentItem.getCost(), currentItem.getDescription()));
        }
        return itemsList;


    }
}
