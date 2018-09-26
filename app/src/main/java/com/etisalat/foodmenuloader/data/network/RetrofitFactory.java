package com.etisalat.foodmenuloader.data.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Retrofit factory class responsible for creating retrofit object
 */
public class RetrofitFactory {

    private static final String BASE_URL = "https://api.androidhive.info";

    protected Retrofit createRetrofitObject() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
