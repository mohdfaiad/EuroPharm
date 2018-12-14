package com.pharogrammer.fedora.europharm.mvp.core;

import com.pharogrammer.fedora.europharm.http.data.BaseDrug;
import com.pharogrammer.fedora.europharm.http.data.OfferDrug;

import io.reactivex.Observable;


public interface OffersDisplayMVP {

    interface View{
        void showConnectionError(String error);
        void provideOfferToView(OfferDrug offerDrug);
    }

    interface Presenter{
        void loadDrugs();
        void setView(OffersDisplayMVP.View view);
        void rxUnsubscribe();
    }

    interface Model{
        Observable<OfferDrug> getOfferDrugs();
    }

}
