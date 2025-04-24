package framework.utils;

import com.aventstack.extentreports.*;
import org.testng.*;

import com.microsoft.playwright.Page;
import framework.base.BaseTest;

public class TestListener implements ITestListener {
    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().pass("Test passed");
        attachScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testThread.get().fail(result.getThrowable());
        attachScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        String htmlPath = System.getProperty("extent.report.path");
        if (htmlPath != null) {
            String pdfPath = htmlPath.replace(".html", ".pdf");
            PDFReportUtil.generatePdfFromHtml("file:" + htmlPath, pdfPath);
        }
        ZipUtil.zipResults("test-output", "test-output/test-results.zip");
    }

    private void attachScreenshot(ITestResult result) {
        Object testClass = result.getInstance();
        Page page = ((BaseTest) testClass).page;
        String methodName = result.getMethod().getMethodName();
        String path = ScreenshotUtil.captureScreenshot(page, methodName);
        try {
            testThread.get().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
