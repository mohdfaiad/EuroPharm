package com.pharogrammer.fedora.europharm.mvp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pharogrammer.fedora.europharm.R;
import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.mvp.core.MainMVP;
import com.pharogrammer.fedora.europharm.root.App;
import com.pharogrammer.fedora.europharm.utils.Consts;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainMVP.View,View.OnClickListener {

    @Inject
    MainMVP.Presenter presenter;

    @BindView(R.id.btn_special_items)
    Button specialDrugsButton;
    @BindView(R.id.btn_all_items)
    Button storeDrugsButton;
    @BindView(R.id.btn_deficient_items)
    Button rareDrugsButton;
    @BindView(R.id.btn_wholesale_items)
    Button wholesaleDrugsButton;
    @BindView(R.id.btn_today_offer)
    Button offerDrugsButton;
    @BindView(R.id.btn_request_items)
    Button requestDrugsButton;

    @BindView(R.id.tv_client_name)
    TextView clientNameTextV;
    @BindView(R.id.tv_balance)
    TextView balanceTextV;

    EuroClient euroClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Dependency Injection to this activity
        ((App)getApplicationContext()).getComponent().inject(this);
        //set this view to the presenter
        presenter.setView(this);
        //Bind ButterKnife to this activity
        ButterKnife.bind(this);

        //get intent from LoginActivity
        euroClient = getIntent().getParcelableExtra(Consts.INTENT_CLIENT_KEY);

        //set client to the presenter to handle it
        presenter.setClient(euroClient);

        presenter.provideMainActivityInfo();

        specialDrugsButton.setOnClickListener(this);
        storeDrugsButton.setOnClickListener(this);
        rareDrugsButton.setOnClickListener(this);
        wholesaleDrugsButton.setOnClickListener(this);
        offerDrugsButton.setOnClickListener(this);
        requestDrugsButton.setOnClickListener(this);

    }

    @Override
    public void displaySubCategory(int intentKey ,EuroClient client) {
        Intent intent = new Intent(MainActivity.this , DrugsDisplayActivity.class);
        intent.putExtra(Consts.INTENT_CLIENT_KEY, client);

        if (intentKey>0){
            intent.putExtra(Consts.SPECIFY_DATA_KEY, intentKey);
        }

        startActivity(intent);
    }

    @Override
    public void displayClientInfo(String clientName, int clientBalance) {
        clientNameTextV.setText(clientName);
        balanceTextV.setText(String.valueOf(clientBalance));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_special_items:
                presenter.specifySubCategory(Consts.SPECIAL_CAT_INTENT);
                break;
            case R.id.btn_all_items:
                presenter.specifySubCategory(Consts.STORE_CAT_INTENT);
                break;
            case R.id.btn_deficient_items:
                presenter.specifySubCategory(Consts.RARE_CAT_INTENT);
                break;
            case R.id.btn_wholesale_items:
                presenter.specifySubCategory(Consts.WHOLESALE_CAT_INTENT);
                break;
            case R.id.btn_today_offer:

                Intent intent = new Intent(MainActivity.this , OffersDisplayActivity.class);
                intent.putExtra(Consts.INTENT_CLIENT_KEY, euroClient);
                startActivity(intent);
                break;
            case R.id.btn_request_items:

                Intent intent2 = new Intent(MainActivity.this , RequestDrugsActivity.class);
                intent2.putExtra(Consts.INTENT_CLIENT_KEY, euroClient);
                startActivity(intent2);

                break;

        }
    }
}
