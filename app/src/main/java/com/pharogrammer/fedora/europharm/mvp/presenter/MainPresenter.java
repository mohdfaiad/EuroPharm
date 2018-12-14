package com.pharogrammer.fedora.europharm.mvp.presenter;

import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.mvp.core.MainMVP;

public class MainPresenter implements MainMVP.Presenter {

    MainMVP.View view;

    private EuroClient presenterEuroClient;

    @Override
    public void setView(MainMVP.View view) {

        if (view != null){
            this.view = view;

        }

    }

    @Override
    public void specifySubCategory(int key) {

        if (view != null){
            view.displaySubCategory(key, presenterEuroClient);
        }

    }

    @Override
    public void setClient(EuroClient client) {

        if (presenterEuroClient == null)
            this.presenterEuroClient = client;

    }

    @Override
    public void provideMainActivityInfo() {
        if(view!= null){
            view.displayClientInfo(presenterEuroClient.getClientName()
                                    ,presenterEuroClient.getBalance());
        }
    }
}
