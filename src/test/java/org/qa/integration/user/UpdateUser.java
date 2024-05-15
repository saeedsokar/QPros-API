package org.qa.integration.user;

import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.ValidatableResponse;
import org.qa.utilities.FlakyRetry;
import org.qa.utilities.RequestHandler;
import org.qa.utilities.RequestModel;
import org.qa.utilities.RestBaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UpdateUser extends RestBaseTest {
    @org.testng.annotations.DataProvider
    private static String[][] getUser() {
        return RestBaseTest.getCustomDataProvider("./src/main/resources/updateUser-test-data.xlsx", "updateUser", true);
    }

    @Test(priority = 0, dataProvider = "getUser", retryAnalyzer = FlakyRetry.class)
    public void createUser(String payload, String username, String statusCode) {
        try {

            Map<String, String> headers = new HashMap<>();
            headers.put("accept", "application/json");
            headers.put("Content-Type", "application/json");

            String completeEndpoint = buildFullPath() + "/" + username;
            RequestModel requestModel = new RequestModel(completeEndpoint, payload, null, headers);
            logger.log(LogStatus.INFO, "script data: expected Status Code: " + statusCode);
            ValidatableResponse response = RequestHandler.putRequest(requestModel).
                    assertThat().
                    statusCode(removeZeroFromExcelSheet(statusCode));
        } catch (Exception ex) {
            logger.log(LogStatus.ERROR, "Failed because: " + ex.getMessage());
        }
    }
}
