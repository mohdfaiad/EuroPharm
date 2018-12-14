package com.pharogrammer.fedora.europharm.mvp.model;

import com.pharogrammer.fedora.europharm.http.data.BaseDrug;
import com.pharogrammer.fedora.europharm.mvp.core.DrugsDisplayMVP;
import com.pharogrammer.fedora.europharm.mvp.repos.Repository;

import io.reactivex.Observable;


public class DrugsDisplayModel implements DrugsDisplayMVP.Model {

    Repository repository;

    public DrugsDisplayModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<BaseDrug> getSpecialDrugs() {
        return repository.getSpecialDrugsFromNetwork();
    }

    @Override
    public Observable<BaseDrug> getStoreDrugs() {
        return repository.getStoreDrugsFromNetwork();
    }

    @Override
    public Observable<BaseDrug> getWholesaleDrugs() {
        return repository.getWholesaleDrugsFromNetwork();
    }

    @Override
    public Observable<BaseDrug> getRareDrugs() {
        return repository.getRareDrugsFromNetwork();
    }
}
