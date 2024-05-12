package org.qa.utilities;

import java.util.HashMap;
import java.util.Map;

public class RequestModel {
    public String endPoint = "";
    public String body = "";
    public Map<String, Object> queryParams = new HashMap<>();
    public Map<String, Object> headers = new HashMap<>();

    public RequestModel(String endPoint, String body) {
        this.endPoint = endPoint;
        this.body = body != null ? body : "";

    }

    public RequestModel(String endPoint, String body, Map<String, Object> queryParams, Map<String, Object> headers) {
        this(endPoint, body);
        this.queryParams = queryParams != null ? queryParams : new HashMap<>();
        this.headers = headers != null ? headers : new HashMap<>();
    }


    //Added to make header fixed with login
//    public RequestModel(String endPoint, String body, Map<String, Object> queryParams, boolean requiredToken) {
//        this(endPoint, body);
//        this.queryParams = queryParams != null ? queryParams : new HashMap<>();
//        if(requiredToken)
//        {
//            HeaderManagement.setHeaders("Authorization", TokenHolder.getToken());
//            HeaderManagement.setHeaders("Content-Type", "application/json");
//            this.headers = HeaderManagement.getHeaders();
//        }
//        else {
//            HeaderManagement.setHeaders("Content-Type", "application/json");
//            this.headers=HeaderManagement.getHeaders();
//        }
//
//    }


}
