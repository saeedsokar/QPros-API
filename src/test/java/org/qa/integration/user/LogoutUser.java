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

public class LogoutUser extends RestBaseTest {
    @org.testng.annotations.DataProvider
    private static String[][] getLogoutData() {
        return RestBaseTest.getCustomDataProvider("./src/main/resources/logout-test-data.xlsx", "logoutUser", true);
    }

    @Test(priority = 0, dataProvider = "getLogoutData", retryAnalyzer = FlakyRetry.class)
    public void logoutUser( String statusCode) {
        try {
            String completeEndpoint = buildFullPath() + "/logout";
            RequestModel requestModel = new RequestModel(completeEndpoint, "", null, null);
            logger.log(LogStatus.INFO, "script data: expected Status Code: " + statusCode);
            ValidatableResponse response = RequestHandler.getRequest(requestModel).
                    assertThat().
                    statusCode(removeZeroFromExcelSheet(statusCode));
        } catch (Exception ex) {
            logger.log(LogStatus.ERROR, "Failed because: " + ex.getMessage());
        }
    }
}
