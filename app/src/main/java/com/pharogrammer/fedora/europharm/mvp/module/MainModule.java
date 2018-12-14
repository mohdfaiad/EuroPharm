package com.pharogrammer.fedora.europharm.mvp.module;

import com.pharogrammer.fedora.europharm.mvp.core.MainMVP;
import com.pharogrammer.fedora.europharm.mvp.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    public MainMVP.Presenter providePresenter(){
        return new MainPresenter();
    }
}
