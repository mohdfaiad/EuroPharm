package com.pharogrammer.fedora.europharm.mvp.presenter;

import com.pharogrammer.fedora.europharm.http.data.OfferDrug;
import com.pharogrammer.fedora.europharm.mvp.core.OffersDisplayMVP;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class OffersDisplayPresenter implements OffersDisplayMVP.Presenter {

    OffersDisplayMVP.View view;
    OffersDisplayMVP.Model model;
    Disposable subscription;

    public OffersDisplayPresenter(OffersDisplayMVP.Model model) {
        this.model = model;
    }

    @Override
    public void loadDrugs() {

        subscription = model.getOfferDrugs().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OfferDrug>() {
                    @Override
                    public void accept(OfferDrug offerDrug) throws Exception {

                        if (view != null){
                            view.provideOfferToView(offerDrug);
                        }


                    }
                });
    }

    @Override
    public void setView(OffersDisplayMVP.View view) {

        if (view!=null){
            this.view = view;
        }
    }

    @Override
    public void rxUnsubscribe() {

        if (subscription != null &&!subscription.isDisposed()){
            subscription.dispose();
        }
    }
}
//
//
//
//@Override
//public void onError(Throwable e) {
//
//        view.showConnectionError(e.getMessage());
//        }
//
//@Override
//public void onNext(OfferDrug offerDrug) {
//        if (view != null){
//
//        view.provideOfferToView(offerDrug);
//
//        }