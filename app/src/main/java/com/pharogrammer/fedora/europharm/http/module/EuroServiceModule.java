package com.pharogrammer.fedora.europharm.http.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.pharogrammer.fedora.europharm.http.api.EuroApiService;
import com.pharogrammer.fedora.europharm.utils.Consts;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class EuroServiceModule {
    @Provides
    OkHttpClient provideClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    Retrofit provideRetrofit(String baseUrl, OkHttpClient client){

//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    EuroApiService provideEuroApiService(){
        return provideRetrofit(Consts.BASE_URL, provideClient())
                .create(EuroApiService.class);
    }
}
