package com.pharogrammer.fedora.europharm.http.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * BaseDrug data model for special drugs & store drugs
 */
public class BaseDrug {

    @SerializedName("_id")
    @Expose
    protected int drugID;
    @SerializedName("brand_name")
    @Expose
    protected String drugName;

    @SerializedName("brand_price")
    @Expose
    protected double drugPrice;

    @SerializedName("brand_discount")
    @Expose
    protected double drugDiscount;

    @SerializedName("max_quantity")
    @Expose
    protected int maxQuantity;

    @SerializedName("min_quantity")
    @Expose
    protected int minQuantity;

    protected int clientClass;


    public BaseDrug(){
    //Empty Constructor
    }


    public int getDrugID() {
        return drugID;
    }

    public void setDrugID(int drugID) {
        this.drugID = drugID;
    }

    public int getClientClass() {
        return clientClass;
    }

    public void setClientClass(int clientClass) {
        this.clientClass = checkClientClass(clientClass);
        this.generateClassDiscount();
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }

    public double getDrugDiscount() {
        return drugDiscount;
    }

    public void setDrugDiscount(double drugDiscount) {
        this.drugDiscount = drugDiscount;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    private int checkClientClass(int clientClass){

        int tempClass = 2;

        if (clientClass > 0 && clientClass < 7 )
            tempClass = clientClass;


        return clientClass;

    }

    private void generateClassDiscount(){

        int addedPercent = this.clientClass - 1;
        this.setDrugDiscount(this.drugDiscount - addedPercent);

    }


}
