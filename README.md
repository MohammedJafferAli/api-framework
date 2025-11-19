# API Testing Framework - Extent Reports

## Overview
Java, Cucumber BDD framework for API testing of JSONPlaceholder REST API with Extent reporting.

## Quick Start
```bash
# Setup
git clone https://github.com/MohammedJafferAli/api-framework.git
cd api-framework
mvn clean install

# Run tests
mvn clean test

# View Extent report
open reports/ExtentReport.html

# Docker execution
docker-compose up --build

# View reports
open reports/ExtentReport.html
```

## Features
- RestAssured for API testing
- Cucumber BDD with TestNG
- Extent Reports with interactive dashboard
- Docker containerization
- GitHub Actions CI/CD
- Multi-environment support

## Structure
```
├── src/test/resources/features/    # BDD feature files
├── src/test/java/                  # Test code
├── reports/ExtentReport.html       # Generated Extent reports
├── logs/                          # Execution logs
└── docker-compose.yml             # Docker setup
```

## Commands
```bash
make test              # Run tests in Docker
make reports          # Open Extent reports
make clean            # Clean up resources
```

## Test Execution & Reporting

### Run Tests
```bash
mvn clean test
```

### Generate & View Extent Report
The Extent report is automatically generated after test execution:
```bash
# Report location
open reports/ExtentReport.html

# Or use browser
firefox reports/ExtentReport.html
```

### Docker Testing
```bash
# Run tests in Docker
docker-compose up --build

# View reports after completion
open reports/ExtentReport.html
```

### Report Features
- Interactive dashboard with test statistics
- Detailed test execution logs
- Screenshots for failed tests
- Timeline view of test execution
- Environment and system information
