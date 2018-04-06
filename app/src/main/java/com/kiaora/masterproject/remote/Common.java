package com.kiaora.masterproject.remote;


import com.kiaora.masterproject.BuildConfig;
import com.kiaora.masterproject.remote.api.APIService;

/**
 * Created by Swapna on 12/15/2017.
 */

public class Common {
    public static final String baseUrl = "https://googleapis.com";
    public static APIService getGoogleApiScalar(){
        return RetrofitClient.getClientScalar(baseUrl).create(APIService.class);
    }
    public static APIService getGoogleApiGson(){
        return RetrofitClient.getClientGson(BuildConfig.APP_BASE_URL).create(APIService.class);
    }
}
