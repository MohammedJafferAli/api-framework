#!/bin/bash

echo "============================================================"
echo "API TESTING FRAMEWORK - DOCKER EXECUTION WITH ALLURE"
echo "============================================================"
echo "Execution Time: $(date '+%Y-%m-%d %H:%M:%S')"
echo "Base URL: https://jsonplaceholder.typicode.com"
echo ""

# Run Maven tests
echo "🧪 Running API tests..."
mvn clean test

# Generate Allure report
echo "📊 Generating Allure report..."
if command -v allure &> /dev/null; then
    allure generate reports/allure-results -o reports/allure-report --clean
    echo "✅ Allure report generated: reports/allure-report/index.html"
else
    echo "⚠️  Allure CLI not found, using Maven plugin..."
    mvn allure:report
fi

echo ""
echo "============================================================"
echo "DOCKER EXECUTION COMPLETED"
echo "============================================================"
echo "📊 Reports generated:"
echo "   - Allure Report: reports/allure-report/index.html"
echo "   - JSON Report: reports/json/Cucumber.json"
echo "   - XML Report: reports/xml/Cucumber.xml"
echo "   - Execution Log: logs/api-tests.log"
