.PHONY: test build clean reports allure-serve allure-generate

# Build and run tests in Docker
test:
	docker-compose up --build --abort-on-container-exit

# Build Docker image
build:
	docker build -t api-framework .

# Clean up Docker resources
clean:
	docker-compose down --volumes --remove-orphans
	docker system prune -f

# Generate Allure report
allure-generate:
	mvn allure:report

# Serve Allure report
allure-serve:
	mvn allure:serve

# Generate and open reports
reports: allure-generate
	@echo "Opening Allure reports..."
	@if [ -f "reports/allure-report/index.html" ]; then \
		open reports/allure-report/index.html; \
	else \
		echo "No Allure reports found. Run 'make test' first."; \
	fi

# Run tests and open reports
test-and-report: test allure-generate reports

# Create folder structure
setup:
	mkdir -p reports/{allure-results,allure-report,json,xml} logs test-results artifacts
	@echo "✅ Folder structure created successfully!"
