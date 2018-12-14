package com.pharogrammer.fedora.europharm.mvp.model;

import com.pharogrammer.fedora.europharm.http.data.DrugRequest;
import com.pharogrammer.fedora.europharm.http.data.DrugRequestResponse;
import com.pharogrammer.fedora.europharm.mvp.core.RequestDrugsMVP;
import com.pharogrammer.fedora.europharm.mvp.repos.Repository;

import io.reactivex.Observable;


public class RequestDrugsModel implements RequestDrugsMVP.Model {

    Repository repository;

    public RequestDrugsModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<DrugRequestResponse> setDrugRequest(DrugRequest drugRequest) {
        return repository.setDrugRequestToNetwork(drugRequest);
    }
}
