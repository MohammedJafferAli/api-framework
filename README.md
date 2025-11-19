# API Testing Framework

## Overview
Java, Cucumber BDD framework for API testing of JSONPlaceholder REST API with enhanced Extent Reports and Allure reporting.

## Quick Start
```bash
# Setup
git clone https://github.com/MohammedJafferAli/api-framework.git
cd api-framework
mvn clean install

# Run tests
mvn clean test

# Docker execution (Recommended)
docker-compose up --build

# View Extent Reports
open target/extent-reports/ExtentReport.html

# Generate Allure report
mvn allure:report

# Serve Allure report
mvn allure:serve
```

## Features
- RestAssured for API testing
- Cucumber BDD with TestNG
- **Enhanced Extent Reports** with stunning visuals
- Allure Reports with interactive dashboard
- Docker containerization
- GitHub Actions CI/CD
- Multi-environment support
- SSL-free configuration for Docker/local environments

## Structure
```
├── src/test/resources/features/    # BDD feature files
├── src/test/java/                  # Test code
├── target/extent-reports/          # Enhanced Extent Reports
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

## Cucumber Feature Execution

### Step-by-Step Instructions

#### 1. Prerequisites
```bash
# Ensure Java 11+ is installed
java -version

# Ensure Maven is installed
mvn -version

# Clone and navigate to project
git clone https://github.com/MohammedJafferAli/api-framework.git
cd api-framework
```

#### 2. Install Dependencies
```bash
# Clean and install all dependencies
mvn clean install
```

#### 3. Run All Cucumber Features
```bash
# Execute all feature files
mvn clean test

# Alternative with specific profile
mvn clean test -Dtest=TestRunner
```

#### 4. Run Specific Feature Files
```bash
# Run specific feature by name
mvn test -Dcucumber.options="src/test/resources/features/posts_api.feature"

# Run multiple specific features
mvn test -Dcucumber.options="src/test/resources/features/posts_api.feature src/test/resources/features/users_api.feature"
```

#### 5. Run Features by Tags
```bash
# Run features with specific tags
mvn test -Dcucumber.options="--tags @smoke"

# Run features excluding certain tags
mvn test -Dcucumber.options="--tags 'not @skip'"
```

#### 6. Docker Execution (Recommended)
```bash
# Build and run tests in Docker
docker-compose up --build

# Run in detached mode
docker-compose up --build -d

# View logs
docker-compose logs -f
```

#### 7. View Test Results
```bash
# View Extent Reports
open target/extent-reports/ExtentReport.html

# Generate and view Allure reports
mvn allure:serve
```

## Test Execution & Reporting

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

## Reporting

### Extent Reports (Enhanced)
```bash
# Run tests to generate Extent Report
mvn clean test

# View stunning visual report
open target/extent-reports/ExtentReport.html
```

**Features:**
- Dark theme with gradient styling
- Animated dashboard cards
- Performance metrics visualization
- Enhanced test timeline
- Mobile responsive design

### Allure Reports
```bash
# Generate Allure report
mvn allure:report

# Serve interactive report
mvn allure:serve
```

**Features:**
- Interactive dashboard with test statistics
- Detailed test execution timeline
- Test categorization and filtering
- Historical trends and comparisons
- Attachments and screenshots
- Environment and system information
- Retry and flaky test analysis

## Environment Notes
- Optimized for Docker and local environments
- No SSL certificate workarounds required
- Cross-platform compatibility (macOS, Linux, Windows)
