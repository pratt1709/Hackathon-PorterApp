package com.prateek.porter.event;

import com.prateek.porter.rest.ParcelDetail;
import com.prateek.porter.rest.ListCarsResponseDto;

import java.util.ArrayList;

/**
 * Created by prateek.kesarwani on 08/03/2016.
 */
public class ParcelDetailsEvent {

    private ArrayList<ParcelDetail> parcelDetailsList;

    public ArrayList<ParcelDetail> getParcelDetailsList() {
        return parcelDetailsList;
    }

    public void setParcelDetailsList(ArrayList<ParcelDetail> parcelDetailsList) {
        this.parcelDetailsList = parcelDetailsList;
    }
}