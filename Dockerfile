FROM maven:3.8.6-openjdk-11

WORKDIR /app

# Copy Maven settings first
COPY settings.xml /root/.m2/settings.xml

# Set Maven options to bypass SSL issues
ENV MAVEN_OPTS="-Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true"

# Copy all files
COPY . .

# Create reports directory
RUN mkdir -p reports/allure-results reports/allure-report logs

# Run tests and generate Allure results
CMD ["mvn", "clean", "test", "-s", "/root/.m2/settings.xml"]
