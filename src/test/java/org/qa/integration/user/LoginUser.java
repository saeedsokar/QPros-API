package org.qa.integration.user;

import com.relevantcodes.extentreports.LogStatus;
import groovy.util.logging.Log;
import io.restassured.response.ValidatableResponse;
import org.qa.utilities.FlakyRetry;
import org.qa.utilities.RequestHandler;
import org.qa.utilities.RequestModel;
import org.qa.utilities.RestBaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginUser extends RestBaseTest {
    @org.testng.annotations.DataProvider
    private static String[][] getLoginData() {
        return RestBaseTest.getCustomDataProvider("./src/main/resources/login-test-data.xlsx", "loginUser", true);
    }

    @Test(priority = 0, dataProvider = "getLoginData", retryAnalyzer = FlakyRetry.class)
    public void loginUser(String username, String password, String statusCode) {
        try {
            Map<String, String> query = new HashMap<>();
            query.put("username",username);
            query.put("password",password);
            String completeEndpoint = buildFullPath() + "/login";
            RequestModel requestModel = new RequestModel(completeEndpoint, "", query, null);
            logger.log(LogStatus.INFO, "script data: " + username + " , expected Status Code: " + statusCode);
            ValidatableResponse response = RequestHandler.getRequest(requestModel).
                    assertThat().
                    statusCode(removeZeroFromExcelSheet(statusCode));
        } catch (Exception ex) {
            logger.log(LogStatus.ERROR, "Failed because: " + ex.getMessage());
        }
    }
}
