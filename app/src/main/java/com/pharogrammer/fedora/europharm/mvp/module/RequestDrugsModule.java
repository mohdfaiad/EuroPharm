package com.pharogrammer.fedora.europharm.mvp.module;

import com.pharogrammer.fedora.europharm.mvp.core.RequestDrugsMVP;
import com.pharogrammer.fedora.europharm.mvp.model.RequestDrugsModel;
import com.pharogrammer.fedora.europharm.mvp.presenter.RequestDrugsPresenter;
import com.pharogrammer.fedora.europharm.mvp.repos.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class RequestDrugsModule {

    @Provides
    RequestDrugsMVP.Presenter providePresenter(RequestDrugsMVP.Model model){
        return new RequestDrugsPresenter(model);
    }

    @Provides
    RequestDrugsMVP.Model provideModel(Repository repository){
        return  new RequestDrugsModel(repository);
    }
}
