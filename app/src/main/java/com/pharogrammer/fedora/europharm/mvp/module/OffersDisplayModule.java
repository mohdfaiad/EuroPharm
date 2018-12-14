package com.pharogrammer.fedora.europharm.mvp.module;

import com.pharogrammer.fedora.europharm.mvp.core.OffersDisplayMVP;
import com.pharogrammer.fedora.europharm.mvp.model.OffersDisplayModel;
import com.pharogrammer.fedora.europharm.mvp.presenter.OffersDisplayPresenter;
import com.pharogrammer.fedora.europharm.mvp.repos.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class OffersDisplayModule {

    @Provides
    OffersDisplayMVP.Presenter providePresenter(OffersDisplayMVP.Model model){
        return new OffersDisplayPresenter(model);
    }

    @Provides
    OffersDisplayMVP.Model provideModel(Repository repository){
        return new OffersDisplayModel(repository);
    }
}
