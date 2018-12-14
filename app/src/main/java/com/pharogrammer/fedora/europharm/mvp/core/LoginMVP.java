package com.pharogrammer.fedora.europharm.mvp.core;

import com.pharogrammer.fedora.europharm.http.data.EuroClient;

import io.reactivex.Observable;


public interface LoginMVP {

    interface View{

        void test(String test);

        void login(EuroClient client);

        void showFailureMessage();

        void displayMainActivity(EuroClient client);

        void showWrongInputMessage();

        void finishLoginActivity();

    }

    interface Presenter{
        //this method used for setting the view(activity)
        // so that the printer can deal with it
        void setView(LoginMVP.View view);

        void checkClientData(EuroClient client);

        void unSubscribe();
    }

    interface Model{

        Observable<EuroClient> getEuroClient(EuroClient client);

    }
}
