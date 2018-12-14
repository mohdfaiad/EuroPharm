package com.pharogrammer.fedora.europharm.mvp.presenter;

import com.pharogrammer.fedora.europharm.http.data.BaseDrug;
import com.pharogrammer.fedora.europharm.mvp.core.DrugsDisplayMVP;
import com.pharogrammer.fedora.europharm.utils.Consts;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class DrugsDisplayPresenter implements DrugsDisplayMVP.Presenter {

    DrugsDisplayMVP.Model model;
    DrugsDisplayMVP.View view;
    Disposable subscription;

    public DrugsDisplayPresenter(DrugsDisplayMVP.Model model) {
        this.model = model;
    }

    @Override
    public void loadDrugs(int key) {

        subscription = getSpecifiedData(key).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseDrug>() {
                    @Override
                    public void accept(BaseDrug baseDrug) throws Exception {

                        if (view != null)
                        view.provideDrugToView(baseDrug);
                    }
                });

    }

    @Override
    public void setView(DrugsDisplayMVP.View view) {
        if (view != null)
            this.view = view;

    }

    @Override
    public void rxUnsubscribe() {
        if (view != null && !subscription.isDisposed()){
            subscription.dispose();
        }
    }

    private Observable<BaseDrug> getSpecifiedData(int key){

        Observable<BaseDrug> tempObservable = null;
        switch(key){
            case Consts.SPECIAL_CAT_INTENT:
                tempObservable = model.getSpecialDrugs();
                break;
            case Consts.STORE_CAT_INTENT:
                tempObservable = model.getStoreDrugs();
                break;
            case Consts.WHOLESALE_CAT_INTENT:
                tempObservable = model.getWholesaleDrugs();
                break;
            case Consts.RARE_CAT_INTENT:
                tempObservable = model.getRareDrugs();
                break;
        }

        return tempObservable;

    }
}
//
//    @Override
//    public void onError(Throwable e) {
//        if (view != null)
//            view.showConnectionError(e.getMessage());
//    }
//
//    @Override
//    public void onNext(BaseDrug drug) {
//        if (view != null)
//            view.provideDrugToView(drug);
