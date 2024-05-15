package org.qa.integration.user;

import com.relevantcodes.extentreports.LogStatus;
import org.qa.utilities.FlakyRetry;
import org.qa.utilities.RequestHandler;
import org.qa.utilities.RequestModel;
import org.qa.utilities.RestBaseTest;
import org.testng.annotations.Test;

public class DeleteUser extends RestBaseTest {

    @org.testng.annotations.DataProvider
    private static String[][] getUserData() {
        return RestBaseTest.getCustomDataProvider("./src/main/resources/deleteUser-test-data.xlsx", "deleteUser", true);
    }

    @Test(priority = 0, dataProvider = "getUserData", retryAnalyzer = FlakyRetry.class)
    public void deleteUserByUsername(String username, String statusCode) {
        try {
            String completeEndpoint = buildFullPath() + "/" + username;
            RequestModel requestModel = new RequestModel(completeEndpoint, "", null, null);
            logger.log(LogStatus.INFO, "script data: " + username + " , expected Status Code: " + statusCode);
            RequestHandler.deleteRequest(requestModel).
                    assertThat().
                    statusCode(removeZeroFromExcelSheet(statusCode))
            ;
        } catch (Exception ex) {
            logger.log(LogStatus.ERROR, "Failed because: " + ex.getMessage());
        }
    }

}
