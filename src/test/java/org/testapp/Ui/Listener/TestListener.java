package org.testapp.Ui.Listener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testapp.Ui.Test.BaseTest;
import org.testapp.Ui.Util.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends BaseTest implements ITestListener {
//    WebDriver driver;
    String filePath = "src/test/java/org/testapp/Ui/ScreenShots";


    public void onTestStart(ITestResult result){
        System.out.println("Test started: "+result.getName());
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Successfully Finished: " +result.getName());
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " +result.getName());
        try {
            TestUtil.captureScreenshot(result.getName().toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




/*        String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver)context.getAttribute("driver");
        takeScreenShot(methodName, driver);*/

    }
/*    public void takeScreenShot(String methodName, WebDriver driver){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " +result.getName());
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage: " +result.getName());
    }
    public void onStart(ITestContext context) {
        System.out.println("This is onStart method: " +context.getOutputDirectory());
    }
    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish method: " +context.getPassedTests());
        System.out.println("This is onFinish method: " +context.getFailedTests());
    }


}
