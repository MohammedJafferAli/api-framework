FROM maven:3.9.4-openjdk-11-slim

WORKDIR /app

# Install Allure CLI
RUN apt-get update && \
    apt-get install -y wget && \
    wget -O allure.tgz https://github.com/allure-framework/allure2/releases/download/2.24.0/allure-2.24.0.tgz && \
    tar -xzf allure.tgz && \
    mv allure-2.24.0 /opt/allure && \
    ln -s /opt/allure/bin/allure /usr/local/bin/allure && \
    rm allure.tgz && \
    apt-get clean

# Copy pom.xml first for better caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Create organized folder structure
RUN mkdir -p reports/allure-results reports/allure-report logs test-results artifacts

# Run tests and generate Allure report
CMD ["sh", "-c", "mvn clean test && allure generate reports/allure-results -o reports/allure-report --clean"]
