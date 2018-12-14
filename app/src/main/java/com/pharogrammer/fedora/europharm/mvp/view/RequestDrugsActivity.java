package com.pharogrammer.fedora.europharm.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pharogrammer.fedora.europharm.R;
import com.pharogrammer.fedora.europharm.http.data.DrugRequest;
import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.mvp.core.RequestDrugsMVP;
import com.pharogrammer.fedora.europharm.root.App;
import com.pharogrammer.fedora.europharm.utils.Consts;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RequestDrugsActivity extends AppCompatActivity implements RequestDrugsMVP.View {

    @Inject
    RequestDrugsMVP.Presenter presenter;

    @BindView(R.id.et_request_drugname)
    EditText drugNameEtext;

    @BindView(R.id.et_request_formulation)
    EditText drugFormulationEtext;

    @BindView(R.id.et_request_conc)
    EditText drugConcEtext;

    @BindView(R.id.et_request_company)
    EditText drugCompanyEtext;

    @BindView(R.id.et_request_price)
    EditText drugPriceEtext;

    @BindView(R.id.btn_request_drug)
    Button requestButton;

    EuroClient euroClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_request_drugs);
        //Bind Dependency Injection to this activity
        ((App)getApplicationContext()).getComponent().inject(this);
        //Bind Butter knife to this activity
        ButterKnife.bind(this);
        //set the view to the presenter so it can recognize where it's injected
        presenter.setView(this);

        //get client extra intent & get data key integer intent
        euroClient = getIntent().getParcelableExtra(Consts.INTENT_CLIENT_KEY);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.sendDataToDatabase();
            }
        });

    }

    @Override
    public void showRequestResponse(String response) {
        Toast.makeText(this, ""+response, Toast.LENGTH_SHORT).show();
    }

    @Override
    public DrugRequest getDataFromForm() {
        DrugRequest request = new DrugRequest();
        request.setBrandName(drugNameEtext.getText().toString());
        request.setBrandFormulatoin(drugFormulationEtext.getText().toString());
        request.setBrandCompany(drugCompanyEtext.getText().toString());
        request.setBrandConc(drugConcEtext.getText().toString());

        if (!drugPriceEtext.getText().toString().isEmpty()){
            request.setBrandPrice(Double.valueOf(drugPriceEtext.getText().toString()));
        }
        request.setClientID(euroClient.getClientID());
        request.setClientUsername(euroClient.getUsername());
        request.setClientName(euroClient.getClientName());
        return request;
    }

    @Override
    public void emptyFields() {
        drugNameEtext.setText("");
        drugCompanyEtext.setText("");
        drugConcEtext.setText("");
        drugFormulationEtext.setText("");
        drugPriceEtext.setText("");
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
