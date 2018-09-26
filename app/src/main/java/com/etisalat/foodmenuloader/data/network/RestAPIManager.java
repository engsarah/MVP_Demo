package com.etisalat.foodmenuloader.data.network;

import com.etisalat.foodmenuloader.data.model.MenuItemsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This class is the retrofit interface to the backend APIs
 */
public interface RestAPIManager {

    @GET("/pizza")
    Call<MenuItemsResponse> getPizzaItems(@Query("format") String format);
}
