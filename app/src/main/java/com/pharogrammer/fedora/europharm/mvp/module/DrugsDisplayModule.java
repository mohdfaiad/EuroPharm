package com.pharogrammer.fedora.europharm.mvp.module;

import com.pharogrammer.fedora.europharm.mvp.core.DrugsDisplayMVP;
import com.pharogrammer.fedora.europharm.mvp.model.DrugsDisplayModel;
import com.pharogrammer.fedora.europharm.mvp.presenter.DrugsDisplayPresenter;
import com.pharogrammer.fedora.europharm.mvp.repos.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class DrugsDisplayModule {


    @Provides
    public DrugsDisplayMVP.Presenter providePresenter(DrugsDisplayMVP.Model model){
        return new DrugsDisplayPresenter(model);
    }

    @Provides
    public DrugsDisplayMVP.Model provideModel(Repository repository){
        return  new DrugsDisplayModel(repository);
    }

}
