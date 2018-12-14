package com.pharogrammer.fedora.europharm.mvp.core;

import com.pharogrammer.fedora.europharm.http.data.DrugRequest;
import com.pharogrammer.fedora.europharm.http.data.DrugRequestResponse;

import io.reactivex.Observable;


public interface RequestDrugsMVP {

    interface View{
        void showRequestResponse(String response);
        DrugRequest getDataFromForm();
        void emptyFields();
    }

    interface Presenter{

        void setView(RequestDrugsMVP.View view);
        void sendDataToDatabase();
        void rxUnsubscribe();
    }

    interface Model{

        Observable<DrugRequestResponse> setDrugRequest(DrugRequest drugRequest);
    }
}
