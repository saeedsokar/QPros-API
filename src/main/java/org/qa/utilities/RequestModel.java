package org.qa.utilities;

import java.util.HashMap;
import java.util.Map;

public class RequestModel {
    public String endPoint = "";
    public String body = "";
    public Map<String, String> queryParams = new HashMap<>();
    public Map<String, String> headers = new HashMap<>();

    public RequestModel(String endPoint, String body) {
        this.endPoint = endPoint;
        this.body = body != null ? body : "";

    }

    public RequestModel(String endPoint, String body, Map<String, String> queryParams, Map<String, String> headers) {
        this(endPoint, body);
        this.queryParams = queryParams != null ? queryParams : new HashMap<>();
        this.headers = headers != null ? headers : new HashMap<>();
    }


}
