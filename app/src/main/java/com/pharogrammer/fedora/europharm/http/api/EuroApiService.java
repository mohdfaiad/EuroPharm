package com.pharogrammer.fedora.europharm.http.api;

import com.pharogrammer.fedora.europharm.http.data.BaseDrug;
import com.pharogrammer.fedora.europharm.http.data.DrugRequestResponse;
import com.pharogrammer.fedora.europharm.http.data.EuroClient;
import com.pharogrammer.fedora.europharm.http.data.OfferDrug;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EuroApiService {

    @FormUrlEncoded
    @POST("/excel/checkclient.php")
    Observable<List<EuroClient>> getClient(@Field("username") String username
            , @Field("password") String password);

    @FormUrlEncoded
    @POST("/excel/insertRequest.php")
    Observable<DrugRequestResponse> setRequest(@Field("brand_name") String brandName
            , @Field("brand_formulation") String brandFormulation
            , @Field("brand_conc") String brandConc
            , @Field("brand_company") String brandCompany
            , @Field("brand_price") double brandPrice
            , @Field("client_id") int clientID
            , @Field("client_username") String clientUsername
            , @Field("client_name") String clientName

    );

    @GET("/excel/getdata.php")
    Observable<List<BaseDrug>> getSpecialDrugs();


    @GET("/excel/getStoreDrugs.php")
    Observable<List<BaseDrug>> getStoreDrugs();


    @GET("/excel/getWholesaleDrugs.php")
    Observable<List<BaseDrug>> getWholesaleDrugs();

    @GET("/excel/getRareDrugs.php")
    Observable<List<BaseDrug>> getRareDrugs();

    @GET("/excel/getOfferDrugs.php")
    Observable<List<OfferDrug>> getOfferDrugs();

}
