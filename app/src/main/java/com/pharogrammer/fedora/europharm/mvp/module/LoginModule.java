package com.pharogrammer.fedora.europharm.mvp.module;

import com.pharogrammer.fedora.europharm.http.api.EuroApiService;
import com.pharogrammer.fedora.europharm.mvp.core.LoginMVP;
import com.pharogrammer.fedora.europharm.mvp.model.LoginModel;
import com.pharogrammer.fedora.europharm.mvp.presenter.LoginPresenter;
import com.pharogrammer.fedora.europharm.mvp.repos.ClientsRepository;
import com.pharogrammer.fedora.europharm.mvp.repos.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    public LoginModule(){

    }
    @Provides
    public LoginMVP.Presenter providePresenter(LoginMVP.Model model){
        return new LoginPresenter(model);
    }

    @Provides
    public LoginMVP.Model provideModel(Repository repository){
        return new LoginModel(repository);
    }

    @Provides
    public Repository provideRepository(EuroApiService euroApiService ){
        return new ClientsRepository(euroApiService);
    }
}
