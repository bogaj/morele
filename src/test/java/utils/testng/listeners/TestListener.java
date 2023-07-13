package utils.testng.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenShotMaker;

public class TestListener implements ITestListener {
    private Logger logger = LogManager.getLogger(TestListener.class);
    @Override
    public void onTestStart(ITestResult result) {
logger.info("Start testu: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test {} zakończony pozytywnie", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test {} zakończony negatywnie", result.getName());
        ScreenShotMaker.makeScreenShot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test {} pominięty", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("Test {} zakończony negatywnie", result.getName());
        ScreenShotMaker.makeScreenShot();
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        logger.info("Test {} przekroczono czas",result.getName());
        ScreenShotMaker.makeScreenShot();
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
