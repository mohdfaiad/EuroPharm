package com.pharogrammer.fedora.europharm.mvp.model;

import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.mvp.core.LoginMVP;
import com.pharogrammer.fedora.europharm.mvp.repos.Repository;

import io.reactivex.Observable;


public class LoginModel implements LoginMVP.Model {

    Repository repository;

    public LoginModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<EuroClient> getEuroClient(EuroClient inputClient) {
        return repository.getClientFromNetwork(inputClient);
    }
}
