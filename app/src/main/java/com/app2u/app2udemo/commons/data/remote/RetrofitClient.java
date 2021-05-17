package com.app2u.app2udemo.commons.data.remote;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static final String authToken = Credentials.basic("test@gmail.com", "1234");

    public static Retrofit getClient(String baseUrl) {
        //Interceptors
            //interceptor for auth credentials
        BasicAuthInterceptor logging = new BasicAuthInterceptor(authToken);
            //interceptor for logs
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (retrofit==null || !retrofit.baseUrl().equals(baseUrl)) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //adding interceptors
            builder.addInterceptor(logging);
            builder.addInterceptor(logInterceptor);
            //finish adding interceptors
            OkHttpClient okHttpClient = builder.build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

}