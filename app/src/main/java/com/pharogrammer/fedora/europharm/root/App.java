package com.pharogrammer.fedora.europharm.root;

import android.app.Application;

import com.pharogrammer.fedora.europharm.http.module.EuroServiceModule;
import com.pharogrammer.fedora.europharm.mvp.module.DrugsDisplayModule;
import com.pharogrammer.fedora.europharm.mvp.module.LoginModule;
import com.pharogrammer.fedora.europharm.mvp.module.MainModule;
import com.pharogrammer.fedora.europharm.mvp.module.OffersDisplayModule;
import com.pharogrammer.fedora.europharm.mvp.module.RequestDrugsModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .mainModule(new MainModule())
                .drugsDisplayModule(new DrugsDisplayModule())
                .offersDisplayModule(new OffersDisplayModule())
                .requestDrugsModule(new RequestDrugsModule())
                .euroServiceModule(new EuroServiceModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return this.component;
    }
}
