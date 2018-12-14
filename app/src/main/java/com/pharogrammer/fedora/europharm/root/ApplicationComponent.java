package com.pharogrammer.fedora.europharm.root;


import com.pharogrammer.fedora.europharm.http.module.EuroServiceModule;
import com.pharogrammer.fedora.europharm.mvp.module.DrugsDisplayModule;
import com.pharogrammer.fedora.europharm.mvp.module.LoginModule;
import com.pharogrammer.fedora.europharm.mvp.module.MainModule;
import com.pharogrammer.fedora.europharm.mvp.module.OffersDisplayModule;
import com.pharogrammer.fedora.europharm.mvp.module.RequestDrugsModule;
import com.pharogrammer.fedora.europharm.mvp.view.DrugsDisplayActivity;
import com.pharogrammer.fedora.europharm.mvp.view.LoginActivity;
import com.pharogrammer.fedora.europharm.mvp.view.MainActivity;
import com.pharogrammer.fedora.europharm.mvp.view.OffersDisplayActivity;
import com.pharogrammer.fedora.europharm.mvp.view.RequestDrugsActivity;

import dagger.Component;

@Component(modules = {ApplicationModule.class,LoginModule.class
        ,EuroServiceModule.class,MainModule.class,DrugsDisplayModule.class
        ,OffersDisplayModule.class, RequestDrugsModule.class})
public interface ApplicationComponent {

    void inject (MainActivity target);
    void inject (LoginActivity target);
    void inject (DrugsDisplayActivity target);
    void inject (OffersDisplayActivity target);
    void inject (RequestDrugsActivity target);
}
