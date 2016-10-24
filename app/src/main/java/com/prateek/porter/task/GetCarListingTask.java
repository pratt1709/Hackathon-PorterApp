package com.prateek.porter.task;

import android.content.Context;
import android.util.Log;

import com.prateek.porter.event.CarListEvent;
import com.prateek.porter.event.FailureEvent;
import com.prateek.porter.event.ParcelDetailsEvent;
import com.prateek.porter.rest.ParcelDetail;
import com.prateek.porter.rest.ListCarsResponseDto;
import com.prateek.porter.rest.PorterService;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by prateek.kesarwani on 08/03/2016.
 */
public class GetParcelDetailsTask {

    Context mApplicationContext;

    private GetParcelDetailsTask(Context applicationContext) {
        this.mApplicationContext = applicationContext;
    }

    public static GetParcelDetailsTaskBuilder newTask() {
        return new GetParcelDetailsTaskBuilder();
    }

    public static class GetParcelDetailsTaskBuilder {

        public GetParcelDetailsTask build(Context applicationContext) {
            return new GetParcelDetailsTask(applicationContext);
        }
    }

    public void execute() {
        fetchParcels();
    }

    private void fetchParcels() {
        PorterService.Implementation.get().getParcel(new Callback<ParcelDetail[]>() {
            @Override
            public void success(Callback<ParcelDetail[]> parcelDetailsList, Response response) {
                Log.e("Success", "Success");
                ParcelDetailsEvent parcelDetailsEvent = new ParcelDetailsEvent();
                parcelDetailsEvent.setParcelDetailsList(new ArrayList<ParcelDetail>(parcelDetailsList));
                mCarListEvent = new CarListEvent();
                mCarListEvent.setListCarsResponseDto(listCarsResponseDto);

                // Also fetch 'Api Hits' in here, as its required in HomePage itself
                // fetchApiHits();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.e("Failure", "Failure");
                EventBus.getDefault().post(new FailureEvent());
            }
        });
    }
}