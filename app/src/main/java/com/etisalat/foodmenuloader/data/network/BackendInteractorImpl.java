package com.etisalat.foodmenuloader.data.network;

import com.etisalat.foodmenuloader.data.DataManager;
import com.etisalat.foodmenuloader.data.model.Item;
import com.etisalat.foodmenuloader.data.model.MenuItemsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * This class is responsible for calling backend restApi to retrieve data
 */

public class BackendInteractorImpl implements BackendInteractor {

    private DataManager dataManager;

    public BackendInteractorImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    /**
     *
     * @return Retrofit Object
     */
    private Retrofit createRetrofitObject()
    {
        return new RetrofitFactory().createRetrofitObject();
    }

    /**
     * Caller Method to retrieve pizza items from rest api
     */
    @Override
    public void loadMenuItems() {

        Retrofit retrofitObject = createRetrofitObject();
        RestAPIManager restAPIManager = retrofitObject.create(RestAPIManager.class);
        Call call = restAPIManager.getPizzaItems("xml");

        /**
         * Retrofit Callbacks
          */
        call.enqueue(new Callback<MenuItemsResponse>() {
            @Override
            public void onResponse(Call<MenuItemsResponse> call, Response<MenuItemsResponse> response) {

                if (response.isSuccessful()) {
                    MenuItemsResponse result = response.body();
                    List<Item> pizzaList = result.getMenuItems();
                    dataManager.onSuccess(pizzaList);
                }
                else
                {
                    dataManager.onFailure("Something went wtong, please try again later");
                }

            }

            @Override
            public void onFailure(Call<MenuItemsResponse> call, Throwable t)
            {
                dataManager.onFailure("Something went wtong, please try again later");
            }
        });
    }
}
