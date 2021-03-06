package com.prateek.porter.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.prateek.porter.R;
import com.prateek.porter.event.FailureEvent;
import com.prateek.porter.event.ParcelDetailsEvent;
import com.prateek.porter.task.GetCarListingTask;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @InjectView(R.id.main_list)
    ListView mMainListView;
    @InjectView(R.id.cars_total_txt)
    TextView mTotalCarsTxt;
    @InjectView(R.id.cars_api_hits_txt)
    TextView mTotalApiHitsTxt;
    private ProgressDialog mProgressDialog;
    private CarListAdapter mMainListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.inject(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getResources().getString(R.string.request_progress));
        mProgressDialog.setCancelable(false);

        mProgressDialog.show();
        GetCarListingTask.newTask().build(this.getApplicationContext()).execute();

    }

    public void onEventMainThread(final ParcelDetailsEvent parcelDetailsEvent) {
        mProgressDialog.hide();
        Toast.makeText(this, R.string.request_success, Toast.LENGTH_LONG).show();

        // Set UI with updated information
        // mTotalCarsTxt.setText("" + carListEvent.getListCarsResponseDto().getCars().size());

        // mTotalApiHitsTxt.setText(carListEvent.getApiHitsResponseDto().getApiHits());

        // Set UI
        // mMainListAdapter = new CarListAdapter(this.getApplicationContext(), carListEvent.getListCarsResponseDto());
        // mMainListView.setAdapter(mMainListAdapter);
    }

    public void onEventMainThread(final FailureEvent failureEvent) {
        mProgressDialog.hide();
        Toast.makeText(this, R.string.failure_network, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.car_footer_sort_price_txt)
    public void onSortByPriceClick(View view) {
        mMainListAdapter.sortByPrice();
    }

    @OnClick(R.id.car_footer_sort_rating_txt)
    public void onSortByRating(View view) {
        mMainListAdapter.sortByRating();
    }
}