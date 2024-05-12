package org.qa.utilities;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class RequestHandler {
    public static ValidatableResponse postRequest(RequestModel requestModel) {
        return given().
                log().all()
                .headers(requestModel.headers)
                .queryParams(requestModel.queryParams)
                .body(requestModel.body)
                .when()
                .post(requestModel.endPoint)
                .then().log().all();
    }

    public static ValidatableResponse getRequest(RequestModel requestModel) {
        return given().
                log().all()
                .headers(requestModel.headers)
                .queryParams(requestModel.queryParams)
                .body(requestModel.body)
                .when()
                .get(requestModel.endPoint)
                .then().
                log().all();
    }
    public static ValidatableResponse putRequest(RequestModel requestModel) {
        return given().
                log().all()
                .headers(requestModel.headers)
                .queryParams(requestModel.queryParams)
                .body(requestModel.body)
                .when()
                .put(requestModel.endPoint)
                .then().log().all();
    }

    public ValidatableResponse deleteRequest(RequestModel requestModel) {
        return given().
                log().all()
                .headers(requestModel.headers)
                .queryParams(requestModel.queryParams)
                .body(requestModel.body)
                .when()
                .delete(requestModel.endPoint)
                .then().log().all();
    }

}
