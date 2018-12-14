package com.pharogrammer.fedora.europharm.mvp.model;

import com.pharogrammer.fedora.europharm.http.data.OfferDrug;
import com.pharogrammer.fedora.europharm.mvp.core.OffersDisplayMVP;
import com.pharogrammer.fedora.europharm.mvp.repos.Repository;

import io.reactivex.Observable;


public class OffersDisplayModel implements OffersDisplayMVP.Model {

    Repository repository;

    public OffersDisplayModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<OfferDrug> getOfferDrugs() {
        return repository.getOfferDrugsFromNetwork();
    }
}
