# API Testing Framework

## Overview
Java, Cucumber BDD framework for API testing of JSONPlaceholder REST API with Allure reporting.

## Quick Start
```bash
# Setup
git clone <repo-url> && cd api-framework
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