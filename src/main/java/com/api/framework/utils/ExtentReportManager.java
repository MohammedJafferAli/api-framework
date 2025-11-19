package com.api.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static final String REPORT_PATH = "target/extent-reports/ExtentReport.html";
    
    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }
    
    private static void createInstance() {
        String reportPath = System.getProperty("user.dir") + File.separator + REPORT_PATH;
        
        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("API Testing Framework | Comprehensive Test Results");
        sparkReporter.config().setReportName("API Testing Framework - Automated Test Report");
        sparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        // System Information
        extent.setSystemInfo("Application", "API Testing Framework");
        extent.setSystemInfo("Environment", "Test Environment");
        extent.setSystemInfo("User", "QA Team");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Execution Date", LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss")));
    }
    
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}