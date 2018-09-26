package com.etisalat.foodmenuloader.data;

import com.etisalat.foodmenuloader.MyApp;
import com.etisalat.foodmenuloader.data.db.database.MenuItemDatabase;
import com.etisalat.foodmenuloader.data.db.model.ItemModel;
import com.etisalat.foodmenuloader.data.model.Item;
import com.etisalat.foodmenuloader.data.model.Mapper;
import com.etisalat.foodmenuloader.data.network.BackendInteractor;
import com.etisalat.foodmenuloader.data.network.BackendInteractorImpl;
import com.etisalat.foodmenuloader.ui.bases.BaseControllerListener;
import com.etisalat.foodmenuloader.utils.NetworkUtils;

import java.util.List;

/**
 * Abstraction class over the data layer
 */

public class AppDataManager implements DataManager {

    //Instance of the BaseControllerListener to be used
    // as call back reference to different Presenters
    private BaseControllerListener mControllerListener;
    private BackendInteractor interactor;
    private List<Item> menuItems = null;
    private MenuItemDatabase menuItemsDatabase;
    private static boolean isCachePopulated;


    public AppDataManager(BaseControllerListener listener) {
        mControllerListener = listener;
        menuItemsDatabase = MenuItemDatabase.getInstance(MyApp.getContext());
    }


    @Override
    public void getMenuItems() {

        boolean isConnectionAvailable = NetworkUtils.isNetworkConnected(MyApp.getContext());

        if (!isConnectionAvailable) {

            mControllerListener.onFailure("Error, No Network Available");

        } else {
            if (!isCachePopulated) {
                getMenuItemsFromBackendAPI();
            } else {
                getMenuItemsFromCache();
            }

        }

    }

    public void getMenuItemsFromBackendAPI() {
        interactor = new BackendInteractorImpl(this);
        interactor.loadMenuItems();
    }

    public void getMenuItemsFromCache() {

        List<ItemModel> itemModels = menuItemsDatabase.getMenuItemDAO().getAll();
        List<Item> ItemsList = Mapper.convertItemModelList(itemModels);

        if(ItemsList.size() != 0)
        {

            mControllerListener.onSuccess(ItemsList);
        }
        else
        {
            mControllerListener.onFailure("Error, No data is available");
        }

    }


    @Override
    public void onSuccess(List<Item> menuItems) {

        this.menuItems = menuItems;
        //Caching retrieved menu items in room database
        List<ItemModel> itemModels = Mapper.convertItemsList(menuItems);

        long[] insertedRecords = menuItemsDatabase.getMenuItemDAO().insertAll(itemModels);

        isCachePopulated = (insertedRecords.length == itemModels.size()) ? true : false;

        mControllerListener.onSuccess(menuItems);
    }

    @Override
    public void onFailure(String errorMessage) {

        mControllerListener.onFailure(errorMessage);


    }


}
