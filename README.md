# API Testing Framework - Allure Reports

## Overview
Java, Cucumber BDD framework for API testing of JSONPlaceholder REST API with Allure reporting.

## Quick Start
```bash
# Setup
git clone https://github.com/MohammedJafferAli/api-framework.git
cd api-framework
git checkout allure-feature
mvn clean install

# Run tests
mvn clean test

# Generate Allure report
mvn allure:report

# Serve Allure report
mvn allure:serve

# Docker execution
docker-compose up --build

# View reports
open reports/allure-report/index.html
```

## Features
- RestAssured for API testing
- Cucumber BDD with TestNG
- Allure Reports with interactive dashboard
- Docker containerization
- GitHub Actions CI/CD
- Multi-environment support

## Structure
```
├── src/test/resources/features/    # BDD feature files
├── src/test/java/                  # Test code
├── reports/allure-results/         # Allure test results
├── reports/allure-report/          # Generated Allure reports
├── logs/                          # Execution logs
└── docker-compose.yml             # Docker setup
```

## Commands
```bash
make test              # Run tests in Docker
make allure-generate   # Generate Allure report
make allure-serve      # Serve Allure report
make reports          # Open Allure reports
make clean            # Clean up resources
```

## Test Execution & Reporting

### Run Tests
```bash
mvn clean test
```

### Generate Allure Report
```bash
# Generate static report
mvn allure:report

# View report
open reports/allure-report/index.html
```

### Serve Interactive Allure Report
```bash
# Start Allure server (interactive)
mvn allure:serve

# This will automatically open browser with live report
```

### Docker Testing
```bash
# Run tests in Docker
docker-compose up --build

# Generate report after completion
mvn allure:report

# View reports
open reports/allure-report/index.html
```

### Report Features
- Interactive dashboard with test statistics
- Detailed test execution timeline
- Test categorization and filtering
- Historical trends and comparisons
- Attachments and screenshots
- Environment and system information
- Retry and flaky test analysis
