package com.pharogrammer.fedora.europharm.http.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EuroClient implements Parcelable {

    @SerializedName("_id")
    @Expose
    private int clientID;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("client_name")
    @Expose
    private String clientName;

    @SerializedName("class")
    @Expose
    private int ClientClass;

    @SerializedName("balance")
    @Expose
    private int balance;

    public EuroClient(){
    //Empty public constructor
    }


    protected EuroClient(Parcel in) {
        clientID = in.readInt();
        username = in.readString();
        password = in.readString();
        clientName = in.readString();
        ClientClass = in.readInt();
        balance = in.readInt();
    }

    public static final Creator<EuroClient> CREATOR = new Creator<EuroClient>() {
        @Override
        public EuroClient createFromParcel(Parcel in) {
            return new EuroClient(in);
        }

        @Override
        public EuroClient[] newArray(int size) {
            return new EuroClient[size];
        }
    };

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientClass() {
        return ClientClass;
    }

    public void setClientClass(int clientClass) {
        ClientClass = clientClass;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(clientID);
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(clientName);
        parcel.writeInt(ClientClass);
        parcel.writeInt(balance);
    }
}
