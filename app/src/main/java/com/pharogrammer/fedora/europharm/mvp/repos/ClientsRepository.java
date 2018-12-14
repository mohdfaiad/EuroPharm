package com.pharogrammer.fedora.europharm.mvp.repos;

import com.pharogrammer.fedora.europharm.http.api.EuroApiService;
import com.pharogrammer.fedora.europharm.http.data.BaseDrug;
import com.pharogrammer.fedora.europharm.http.data.DrugRequest;
import com.pharogrammer.fedora.europharm.http.data.DrugRequestResponse;
import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.http.data.OfferDrug;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;


public class ClientsRepository implements Repository {

    EuroApiService euroApiService;

    public ClientsRepository(EuroApiService euroApiService) {
        this.euroApiService = euroApiService;
    }

    @Override
    public Observable<EuroClient> getClientFromNetwork(EuroClient inputClient) {
        return euroApiService.getClient(inputClient.getUsername() ,inputClient.getPassword()).flatMap(new Function<List<EuroClient>, ObservableSource<EuroClient>>() {
            @Override
            public ObservableSource<EuroClient> apply(List<EuroClient> euroClients) throws Exception {
                return Observable.fromIterable(euroClients);
            }
        });
    }

    @Override
    public Observable<DrugRequestResponse> setDrugRequestToNetwork(DrugRequest drugRequest) {
        return euroApiService.setRequest(drugRequest.getBrandName()
        ,drugRequest.getBrandFormulatoin(),drugRequest.getBrandConc()
        ,drugRequest.getBrandCompany(), drugRequest.getBrandPrice()
        ,drugRequest.getClientID(),drugRequest.getClientUsername()
        ,drugRequest.getClientName());
    }

    @Override
    public Observable<BaseDrug> getSpecialDrugsFromNetwork() {
        return euroApiService.getSpecialDrugs().flatMap(new Function<List<BaseDrug>, ObservableSource<BaseDrug>>() {
            @Override
            public ObservableSource<BaseDrug> apply(List<BaseDrug> baseDrugs) throws Exception {
                return Observable.fromIterable(baseDrugs);
            }
        });
    }

    @Override
    public Observable<BaseDrug> getStoreDrugsFromNetwork() {
        return euroApiService.getStoreDrugs().flatMap(new Function<List<BaseDrug>, ObservableSource<BaseDrug>>() {
            @Override
            public ObservableSource<BaseDrug> apply(List<BaseDrug> baseDrugs) throws Exception {
                return Observable.fromIterable(baseDrugs);
            }
        });
    }

    @Override
    public Observable<BaseDrug> getWholesaleDrugsFromNetwork() {
        return euroApiService.getWholesaleDrugs().flatMap(new Function<List<BaseDrug>, ObservableSource<BaseDrug>>() {
            @Override
            public ObservableSource<BaseDrug> apply(List<BaseDrug> baseDrugs) throws Exception {
                return Observable.fromIterable(baseDrugs);
            }
        });
    }

    @Override
    public Observable<BaseDrug> getRareDrugsFromNetwork() {
        return euroApiService.getRareDrugs().flatMap(new Function<List<BaseDrug>, ObservableSource<BaseDrug>>() {
            @Override
            public ObservableSource<BaseDrug> apply(List<BaseDrug> baseDrugs) throws Exception {
                return Observable.fromIterable(baseDrugs);
            }
        });
    }

    @Override
    public Observable<OfferDrug> getOfferDrugsFromNetwork() {
        return euroApiService.getOfferDrugs().flatMap(new Function<List<OfferDrug>, ObservableSource<OfferDrug>>() {
            @Override
            public ObservableSource<OfferDrug> apply(List<OfferDrug> offerDrugs) throws Exception {
                return Observable.fromIterable(offerDrugs);
            }
        });
    }
}
