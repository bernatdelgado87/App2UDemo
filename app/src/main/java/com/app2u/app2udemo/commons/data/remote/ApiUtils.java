package com.app2u.app2udemo.commons.data.remote;

public class ApiUtils {
    public static final String APP2U_URL_BASE = "https://inphototest.app2u.es/";

    public static ApiInterface getServiceClient() {
        return RetrofitClient.getClient(APP2U_URL_BASE).create(ApiInterface.class);
    }
}
