package org.qa.integration.user;

import com.relevantcodes.extentreports.LogStatus;
import org.qa.utilities.RequestHandler;
import org.qa.utilities.RequestModel;
import org.qa.utilities.RestBaseTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetUser extends RestBaseTest {

    @org.testng.annotations.DataProvider
    private static String[][] getUserData() {
        return RestBaseTest.getCustomDataProvider("./src/main/resources/Users-test-data.xlsx", "getUser", true);
    }

    @Test(priority = 0, dataProvider = "getUserData")
    public void getUserByUsername(String username, String statusCode, String email) {
        try {
            String completeEndpoint = buildFullPath() + "/" + username;
            RequestModel requestModel = new RequestModel(completeEndpoint, "", null, null);
            logger.log(LogStatus.INFO, "script data: " + username + " , expected Status Code: " + statusCode + " ,expected email: " + email);
            RequestHandler.getRequest(requestModel).
                    assertThat().
                    statusCode(removeZeroFromExcelSheet(statusCode))
//                    .body("email", equalTo(email), notNullValue());
            ;
        } catch (Exception ex) {
            logger.log(LogStatus.ERROR, "Failed because: " + ex.getMessage());
        }
    }

}
