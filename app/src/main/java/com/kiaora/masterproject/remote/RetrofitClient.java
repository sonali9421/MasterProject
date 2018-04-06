package com.kiaora.masterproject.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Swapna on 12/15/2017.
 */

public class RetrofitClient {
    private static Retrofit mRetrofitScalar = null;
    private static Retrofit mRetrofitGson = null;

    public static Retrofit getClientScalar(String baseUrl) {
        if (mRetrofitScalar == null) {
            mRetrofitScalar = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return mRetrofitScalar;
    }

    public static Retrofit getClientGson(String baseUrl){
        if (mRetrofitGson == null) {
            mRetrofitGson = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofitGson;
    }
}
