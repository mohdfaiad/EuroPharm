package com.pharogrammer.fedora.europharm.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.pharogrammer.fedora.europharm.R;
import com.pharogrammer.fedora.europharm.http.data.BaseDrug;
import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.mvp.core.DrugsDisplayMVP;
import com.pharogrammer.fedora.europharm.root.App;
import com.pharogrammer.fedora.europharm.utils.Consts;
import com.pharogrammer.fedora.europharm.utils.DrugsAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrugsDisplayActivity extends AppCompatActivity implements DrugsDisplayMVP.View {


    @Inject
    DrugsDisplayMVP.Presenter presenter;

    @BindView(R.id.rv_drugs)
    RecyclerView rvDrugs;

    List<BaseDrug> drugList;
    RecyclerView.Adapter drugsAdapter;

    EuroClient euroClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugs_display);

        //Bind Dependency Injection to this activity
        ((App)getApplicationContext()).getComponent().inject(this);
        //Bind Butterknife to this activity
        ButterKnife.bind(this);
        //set the view to the presenter so it can recogonize where it's injected
        presenter.setView(this);

        //get client extra intent & get data key integer intent
        euroClient = getIntent().getParcelableExtra(Consts.INTENT_CLIENT_KEY);
        int key = getIntent().getIntExtra(Consts.SPECIFY_DATA_KEY,0);
        drugList = new ArrayList<>();
        rvDrugs.setLayoutManager(new LinearLayoutManager(this));
        rvDrugs.setHasFixedSize(true);

        drugsAdapter = new DrugsAdapter(drugList);
        rvDrugs.setAdapter(drugsAdapter);

        //Toast.makeText(this, "" + key, Toast.LENGTH_SHORT).show();
        if (key >0){
            presenter.loadDrugs(key);
        }


    }

    @Override
    public void showConnectionError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void provideDrugToView(BaseDrug drug) {

        if (drug != null){
            drug.setClientClass(euroClient.getClientClass());
            drugList.add(drug);
            drugsAdapter.notifyItemInserted(drugList.size() - 1);
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
