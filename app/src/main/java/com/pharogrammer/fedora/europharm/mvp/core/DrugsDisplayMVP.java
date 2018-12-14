package com.pharogrammer.fedora.europharm.mvp.core;

import com.pharogrammer.fedora.europharm.http.data.BaseDrug;

import io.reactivex.Observable;


public interface DrugsDisplayMVP {

    interface View{

        void showConnectionError(String error);
        void provideDrugToView(BaseDrug drug);

    }

    interface Presenter{

        void loadDrugs(int key);
        void setView(DrugsDisplayMVP.View view);
        void rxUnsubscribe();

    }

    interface Model{

        Observable<BaseDrug> getSpecialDrugs();
        Observable<BaseDrug> getStoreDrugs();
        Observable<BaseDrug> getWholesaleDrugs();
        Observable<BaseDrug> getRareDrugs();

    }
}
