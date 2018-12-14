package com.pharogrammer.fedora.europharm.mvp.core;

import com.pharogrammer.fedora.europharm.http.data.EuroClient;

public interface MainMVP {

    interface View{

        void displaySubCategory(int intentKey,EuroClient client);
        void displayClientInfo(String clientName , int clientBalance);
    }

    interface Presenter{

        void setView(MainMVP.View view);
        void specifySubCategory(int key);
        void setClient(EuroClient client);
        void provideMainActivityInfo();
    }

    interface Model{

    }

}
