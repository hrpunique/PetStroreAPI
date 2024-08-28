package Api.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentReports extent;
    public ExtentTest test;
    
    /*
     * 
     *  public void onStart(ITestContext testContext) {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    String repName = "Test-Report-" + timeStamp + ".html";
    
    extent = new ExtentReports();
    
    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repName);
    sparkReporter.config().setDocumentTitle("RestAssuredAutomationFramework");
    sparkReporter.config().setReportName("Pet Store Users API");
    sparkReporter.config().setTheme(Theme.DARK);
    
    extent.attachReporter(sparkReporter);
    extent.setSystemInfo("Application", "PetStore Users API");
    extent.setSystemInfo("Operating System", System.getProperty("os.name"));
    extent.setSystemInfo("User Name", System.getProperty("user.name"));
    extent.setSystemInfo("Environment", "QA");
    extent.setSystemInfo("user", "pratik");
}*/
    
    
public ExtentSparkReporter sparkReporter;
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName = "Test-Report-" + timeStamp + ".html";
        
        extent = new ExtentReports();	
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repName);
        sparkReporter.config().setDocumentTitle("RestAssuredAutomationFramework");
        sparkReporter.config().setReportName("Pet Store Users API");
        sparkReporter.config().setTheme(Theme.DARK);
        
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "PetStore Users API");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
    extent.setSystemInfo("Environment", "QA");
    extent.setSystemInfo("user", "pratik");
    }

    
    public void onTestSuccess(ITestResult result) {
    	  test=extent.createTest(result.getName());
          test.assignCategory(result.getMethod().getGroups());
          test.createNode(result.getName());
          test.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
    	test=extent.createTest(result.getName());
    test.createNode(result.getName());
    test.assignCategory(result.getMethod().getGroups());
    test.log(Status.FAIL, "Test Failed");
    test.log(Status.FAIL, result.getThrowable().getMessage());
    
    }

    public void onTestSkipped(ITestResult result) {
        test.skip(result.getThrowable());
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();
    }
}

