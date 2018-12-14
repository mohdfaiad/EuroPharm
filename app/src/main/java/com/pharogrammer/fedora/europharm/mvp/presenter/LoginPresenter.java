package com.pharogrammer.fedora.europharm.mvp.presenter;


import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.mvp.core.LoginMVP;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginMVP.Presenter {

    LoginMVP.View view;
    LoginMVP.Model model;

    Disposable subscription;
    CompositeDisposable compositeDisposable;

    private int isLogged = 0;

    public LoginPresenter(LoginMVP.Model model){

        this.model = model;
    }
    @Override
    public void setView(LoginMVP.View view) {

            this.view = view;

    }

    @Override
    public void checkClientData(final EuroClient inputClient) {

        if (view != null && inputClient != null){

            compositeDisposable = new CompositeDisposable();
           Disposable mydisposible =  model.getEuroClient(inputClient).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<EuroClient>() {
                        @Override
                        public void accept(EuroClient client) throws Exception {

                        }
                    });

        }
    }

    @Override
    public void unSubscribe() {
        if (subscription != null && !subscription.isDisposed()){
            subscription.dispose();
        }
    }


}
//
//
//    @Override
//    public void onCompleted() {
//
//        if(isLogged == 0){
//            view.showWrongInputMessage();
//        }else{
//            view.finishLoginActivity();
//        }
//
//    }
//
//    @Override
//    public void onError(Throwable e) {
//        view.showFailureMessage();
//    }
//
//    @Override
//    public void onNext(EuroClient client) {
//
//        if (client != null | !client.getUsername().equals("")){
//            view.displayMainActivity(client);
//            isLogged = 1;
//        }else if(client.getUsername().isEmpty()){
//            view.showWrongInputMessage();
//        }
//    }
//});