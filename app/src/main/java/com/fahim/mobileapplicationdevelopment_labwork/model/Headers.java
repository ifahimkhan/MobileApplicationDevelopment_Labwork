package com.fahim.mobileapplicationdevelopment_labwork.model;

import com.google.gson.annotations.SerializedName;

public class Headers{
    @SerializedName("Accept")
    public String accept;
    @SerializedName("Accept-Encoding") 
    public String acceptEncoding;
    @SerializedName("Accept-Language") 
    public String acceptLanguage;
    @SerializedName("Host") 
    public String host;
    @SerializedName("Priority") 
    public String priority;
    @SerializedName("Sec-Ch-Ua") 
    public String secChUa;
    @SerializedName("Sec-Ch-Ua-Mobile") 
    public String secChUaMobile;
    @SerializedName("Sec-Ch-Ua-Platform") 
    public String secChUaPlatform;
    @SerializedName("Sec-Fetch-Dest") 
    public String secFetchDest;
    @SerializedName("Sec-Fetch-Mode") 
    public String seFetchMode;
    @SerializedName("Sec-Fetch-Site") 
    public String secFetchSite;
    @SerializedName("Sec-Fetch-User") 
    public String secFetchUser;
    @SerializedName("Upgrade-Insecure-Requests") 
    public String upgradeInsecureRequests;
    @SerializedName("User-Agent") 
    public String userAgent;
    @SerializedName("X-Amzn-Trace-Id") 
    public String xAmznTraceId;
}
