package com.pharogrammer.fedora.europharm.http.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DrugRequestResponse {

    @SerializedName("status")
    @Expose
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
