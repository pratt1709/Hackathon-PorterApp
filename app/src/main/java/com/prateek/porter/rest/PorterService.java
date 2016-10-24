package com.prateek.porter.rest;

/**
 * Created by prateek.kesarwani on 08/03/2016.
 */

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;

public interface PorterService {

    public static final String end_point = "https://api-test.theporter.in/";
    // public static final String host_path = "/api/zoomcar/";

    // public static final String GET_CAR_LISTING = host_path + "?type=json&query=list_cars";

    // public static final String GET_API_HITS = host_path + "?type=json&query=api_hits";

    public static final String GET_PARCEL_DETAILS = "interview_api/parcels/all_parcels.json";

    @GET(GET_PARCEL_DETAILS)
    void getParcel(Callback<ParcelDetail[]> callback);

    class Implementation {
        public static PorterService get() {
            return getBuilder()
                    .build()
                    .create(PorterService.class);
        }

        static RestAdapter.Builder getBuilder() {

            // TODO Timeout values should also be taken from configuration. Need to figure out how.
            final OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient.setReadTimeout(20, TimeUnit.SECONDS);
            okHttpClient.setConnectTimeout(20, TimeUnit.SECONDS);

            // TODO Need to set Endpoint path in here from configuration.
            // TODO Logging level should also be pulled from configuration so as to have no logging in release.
            return new RestAdapter.Builder()
                    .setClient(new OkClient(okHttpClient))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(end_point);
        }
    }
}