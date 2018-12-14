package com.pharogrammer.fedora.europharm.mvp.repos;

import com.pharogrammer.fedora.europharm.http.data.BaseDrug;
import com.pharogrammer.fedora.europharm.http.data.DrugRequest;
import com.pharogrammer.fedora.europharm.http.data.DrugRequestResponse;
import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.http.data.OfferDrug;

import io.reactivex.Observable;


public interface Repository {

    Observable<EuroClient> getClientFromNetwork(EuroClient client);

    Observable<DrugRequestResponse> setDrugRequestToNetwork(DrugRequest drugRequest);

    Observable<BaseDrug> getSpecialDrugsFromNetwork();

    Observable<BaseDrug> getStoreDrugsFromNetwork();

    Observable<BaseDrug> getWholesaleDrugsFromNetwork();

    Observable<BaseDrug> getRareDrugsFromNetwork();

    Observable<OfferDrug> getOfferDrugsFromNetwork();
}
