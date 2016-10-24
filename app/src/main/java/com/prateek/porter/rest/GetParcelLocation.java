package com.prateek.porter.rest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by prateek.kesarwani on 08/03/16.
 */
public class GetParcelLocation {

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("long")
    private double longitude;

}
