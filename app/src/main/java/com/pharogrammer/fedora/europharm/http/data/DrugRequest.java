package com.pharogrammer.fedora.europharm.http.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DrugRequest {
    //brand_name brand_formulation brand_conc brand_company
    // brand_price client_id client_username client_name
    @SerializedName("brand_name")
    @Expose
    private String brandName;

    @SerializedName("brand_formulation")
    @Expose
    private String brandFormulatoin;

    @SerializedName("brand_conc")
    @Expose
    private String brandConc;

    @SerializedName("brand_company")
    @Expose
    private String brandCompany;

    @SerializedName("brand_price")
    @Expose
    private double brandPrice;

    @SerializedName("client_id")
    @Expose
    private int clientID;

    @SerializedName("client_username")
    @Expose
    private String clientUsername;

    @SerializedName("client_name")
    @Expose
    private String clientName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandFormulatoin() {
        return brandFormulatoin;
    }

    public void setBrandFormulatoin(String brandFormulatoin) {
        this.brandFormulatoin = brandFormulatoin;
    }

    public String getBrandConc() {
        return brandConc;
    }

    public void setBrandConc(String brandConc) {
        this.brandConc = brandConc;
    }

    public String getBrandCompany() {
        return brandCompany;
    }

    public void setBrandCompany(String brandCompany) {
        this.brandCompany = brandCompany;
    }

    public double getBrandPrice() {
        return brandPrice;
    }

    public void setBrandPrice(double brandPrice) {
        this.brandPrice = brandPrice;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
