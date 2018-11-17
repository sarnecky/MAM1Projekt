package com.example.sarne.mam1;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class WeatherApiClient {
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?";
    private final static String API_KEY = "b0c16190b511c7f9e7b377067750b89d";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(RequestParams params, AsyncHttpResponseHandler responseHandler) {
        params.put("APPID", API_KEY);
        client.get(BASE_URL, params, responseHandler);
    }
}
