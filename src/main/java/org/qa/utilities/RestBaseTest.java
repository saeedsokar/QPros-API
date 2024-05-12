package org.qa.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import org.qa.QACore;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Properties;

public class RestBaseTest extends QACore {
    protected static Properties serverProperties = new Properties();
    public static ExtentReports extentReports;
    public static ExtentTest logger;

    private static final String BASEURL = "baseURL";
    private static final String VERSION = "version";

    private static final String USER_PATH = "userPath";

    protected void loadOnSuiteStart() throws Exception {
        serverProperties = getConfigsValue("Config-Rest.properties");
    }

    private void reportHandler() {
        System.out.println(LocalDateTime.now());
        extentReports = new ExtentReports("reports/index/report " + LocalDateTime.now() + ".html");
        extentReports.addSystemInfo("Automation", "Quality Professionals Assignment");
        extentReports.addSystemInfo("Author", "Saeed Sokar");
        extentReports.addSystemInfo("version", "1");
    }

    @BeforeSuite
    protected void beforeSuite() throws Exception {
        loadOnSuiteStart();
        RestAssured.baseURI = serverProperties.getProperty(BASEURL);
        reportHandler();
    }

    @AfterSuite
    protected void afterSuite() throws Exception {
        extentReports.flush();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        logger = extentReports.startTest(method.getName());
    }

    @AfterMethod
    public void afterMethod(Method method, ITestResult result) throws InterruptedException {

        if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Failed due to: " + result.getThrowable());
            logger.log(LogStatus.FAIL, logger.getDescription());
        } else {
            logger.log(LogStatus.SKIP, "Test escape as there is no error/exception ");
        }
    }

    protected static String[][] getCustomDataProvider(String filePath, String sheetName, boolean isSkipHeader) {
        return readExcelSheet(filePath, sheetName, isSkipHeader);
    }

    public String buildFullPath() {
        return serverProperties.getProperty(VERSION) + "" + serverProperties.getProperty(USER_PATH);
    }
}
