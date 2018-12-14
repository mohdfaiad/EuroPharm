package com.pharogrammer.fedora.europharm.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.pharogrammer.fedora.europharm.R;
import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.http.data.OfferDrug;
import com.pharogrammer.fedora.europharm.mvp.core.OffersDisplayMVP;
import com.pharogrammer.fedora.europharm.root.App;
import com.pharogrammer.fedora.europharm.utils.Consts;
import com.pharogrammer.fedora.europharm.utils.OffersAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OffersDisplayActivity extends AppCompatActivity implements OffersDisplayMVP.View {

    @Inject
    OffersDisplayMVP.Presenter presenter;

    @BindView(R.id.rv_offers)
    RecyclerView rvOffers;

    List<OfferDrug> offerDrugList;
    RecyclerView.Adapter offersAdapter;

    EuroClient euroClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_display);

        //Bind Dependency Injection to this activity
        ((App)getApplicationContext()).getComponent().inject(this);
        //Bind Butterknife to this activity
        ButterKnife.bind(this);
        //set the view to the presenter so it can recogonize where it's injected
        presenter.setView(this);

        //get client extra intent & get data key integer intent
        euroClient = getIntent().getParcelableExtra(Consts.INTENT_CLIENT_KEY);

        offerDrugList = new ArrayList<>();
        rvOffers.setLayoutManager(new LinearLayoutManager(this));
        rvOffers.setHasFixedSize(true);

        offersAdapter = new OffersAdapter(offerDrugList);
        rvOffers.setAdapter(offersAdapter);

        presenter.loadDrugs();

    }

    @Override
    public void showConnectionError(String error) {

        Toast.makeText(this, "" + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void provideOfferToView(OfferDrug offerDrug) {

        if (offerDrug != null){
            offerDrug.setClientClass(euroClient.getClientClass());
            offerDrugList.add(offerDrug);
            offersAdapter.notifyItemInserted(offerDrugList.size() - 1);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnsubscribe();
    }
}
