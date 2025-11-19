package com.api.framework;

import com.api.framework.listeners.ExtentTestListener;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoReportTest {
    
    @Test(description = "Demo test to showcase enhanced Extent Report styling")
    public void testEnhancedReportStyling() {
        ExtentTestListener.getTest().log(Status.INFO, "Starting API Testing Framework demo test");
        ExtentTestListener.getTest().log(Status.INFO, "Testing enhanced visual report features");
        
        // Simulate API test steps
        ExtentTestListener.getTest().log(Status.PASS, "✅ API endpoint validation successful");
        ExtentTestListener.getTest().log(Status.PASS, "✅ Response time within acceptable limits");
        ExtentTestListener.getTest().log(Status.PASS, "✅ Data validation completed");
        
        Assert.assertTrue(true, "Demo test completed successfully");
    }
    
    @Test(description = "Performance metrics demonstration")
    public void testPerformanceMetrics() {
        ExtentTestListener.getTest().log(Status.INFO, "📊 Performance test execution started");
        ExtentTestListener.getTest().log(Status.INFO, "Response Time: 245ms | Status: PASS");
        ExtentTestListener.getTest().log(Status.PASS, "🚀 Performance benchmarks met");
        
        Assert.assertTrue(true, "Performance test passed");
    }
}