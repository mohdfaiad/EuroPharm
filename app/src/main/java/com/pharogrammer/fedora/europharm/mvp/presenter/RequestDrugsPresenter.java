package com.pharogrammer.fedora.europharm.mvp.presenter;

import com.pharogrammer.fedora.europharm.http.data.DrugRequest;
import com.pharogrammer.fedora.europharm.http.data.DrugRequestResponse;
import com.pharogrammer.fedora.europharm.mvp.core.RequestDrugsMVP;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class RequestDrugsPresenter implements RequestDrugsMVP.Presenter {

    RequestDrugsMVP.View view;
    RequestDrugsMVP.Model model;
    Disposable subscription;

    public RequestDrugsPresenter(RequestDrugsMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(RequestDrugsMVP.View view) {

        if (view != null){
            this.view = view;
        }
    }

    @Override
    public void sendDataToDatabase() {

        DrugRequest request = view.getDataFromForm();
        subscription = model.setDrugRequest(request).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DrugRequestResponse>() {
                    @Override
                    public void accept(DrugRequestResponse drugRequestResponse) throws Exception {
                        if (drugRequestResponse.getStatus() == 1){
                            view.showRequestResponse("تم ارسال الطلب بنجاح");
                            view.emptyFields();
                        }else{
                            view.showRequestResponse("خطأ فى البيانات المدخلة");
                        }
                    }
                });




    }

    @Override
    public void rxUnsubscribe() {
        if (subscription != null && !subscription.isDisposed()){
            subscription.dispose();
        }
    }
}

//
//@Override
//public void onNext(DrugRequestResponse drugRequestResponse) {
//
//        if (drugRequestResponse.getStatus() == 1){
//        view.showRequestResponse("تم ارسال الطلب بنجاح");
//        view.emptyFields();
//        }else{
//        view.showRequestResponse("خطأ فى البيانات المدخلة");
//        }
//
//        }