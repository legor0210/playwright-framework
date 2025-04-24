# playwright-framework
# 🎭 Playwright Java Automation Framework

A scalable, object-oriented Test Automation Framework using **Playwright**, **Java**, **TestNG**, **ExtentReports**, and **Maven**. It includes features like parallel execution, automatic screenshots, retry logic, PDF report generation, and HTML reporting with dark theme.

---

## 📁 Project Structure
project-root/ ├── src/ │ ├── main/java/framework/ │ │ ├── base/ → Base classes for Playwright setup │ │ ├── utils/ → Utilities (retry, screenshot, PDF, etc.) │ │ └── reports/ → ExtentReports setup │ └── test/java/tests/ → TestNG test classes ├── test-output/ → Reports and screenshots ├── pom.xml → Maven build and dependencies ├── testng.xml → TestNG suite config └── README.md

---

## ⚙️ Features

- ✅ Playwright Java browser automation
- ✅ TestNG integration with retry logic
- ✅ ExtentReports (HTML + dark theme + screenshots + test descriptions)
- ✅ PDF report generation using OpenHtmlToPdf
- ✅ Page screenshot capture on success or failure
- ✅ Object-Oriented Programming (OOP) design
- ✅ Multi-threaded execution with thread-safe `ThreadLocal` pattern
- ✅ Auto-zipping of report folder with timestamp

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/playwright-framework.git
cd playwright-framework

### 2. Build the Project

```bash
mvn clean install

### 2. Run the Tests

```bash
mvn test

Report Outputs
🌐 Extent HTML Report: test-output/ExtentReport-[timestamp].html

📸 Screenshots: Captured per test in test-output/screenshots/

📕 PDF Report: Auto-generated from HTML via OpenHtmlToPdf

🗜️ Zipped Results: results-[timestamp].zip

🧪 Sample Test
java
Copy
Edit
@Test(description = "Verify valid login", retryAnalyzer = RetryAnalyzer.class)
public void testValidLogin() {
    page.navigate("https://example.com/login");
    page.fill("#username", "user");
    page.fill("#password", "pass");
    page.click("xpath=//button[@name='login']");
    Assert.assertTrue(page.isVisible("#logout"), "Logout button not visible");
}
📄 Report Outputs
🌐 Extent HTML Report: test-output/ExtentReport-[timestamp].html

📸 Screenshots: Captured per test in test-output/screenshots/

📕 PDF Report: Auto-generated from HTML via OpenHtmlToPdf

🗜️ Zipped Results: results-[timestamp].zip

📦 Dependencies (pom.xml)

<dependencies>
  <dependency>
    <groupId>com.microsoft.playwright</groupId>
    <artifactId>playwright</artifactId>
    <version>1.42.0</version>
  </dependency>
  <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.9.0</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.1</version>
  </dependency>
  <dependency>
    <groupId>com.openhtmltopdf</groupId>
    <artifactId>openhtmltopdf-pdfbox</artifactId>
    <version>1.0.10</version>
  </dependency>
</dependencies>

🧰 Utilities Included
BaseTest – Sets up Playwright and browser context per test

ScreenshotUtil – Captures screenshots and names them by method

RetryAnalyzer – Retries failed tests automatically

PDFReportUtil – Converts Extent HTML to PDF

TestListener – Listens to test events (on start, success, failure, finish)

ExtentManager – Singleton ExtentReports instance with dark theme

🔄 Parallel Execution
To run tests in parallel, configure testng.xml:

<suite name="All Tests" parallel="methods" thread-count="3">
  <test name="Login Tests">
    <classes>
      <class name="tests.LoginTest"/>
    </classes>
  </test>
</suite>
Use ThreadLocal variables in BaseTest for thread safety.

🔐 Test Descriptions and Logs
Each @Test can include a description shown in the HTML report.

Assertion failures log descriptive messages.

Extent report logs steps per test, including status and screenshots.

🗜️ Auto-Zip Feature
After test run, all reports and screenshots are zipped:

Example: results-2025-04-24_15-30-59.zip

You can send this archive via email or store for CI/CD artifacts.

💡 Notes
Ensure Java SDK 17 is set in IntelliJ project structure.

If you get release version 5 not supported, upgrade your maven-compiler-plugin:
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.10.1</version>
      <configuration>
        <source>17</source>
        <target>17</target>
      </configuration>
    </plugin>
  </plugins>
</build>

👨‍💻 Author
Nicko
📍 QA Automation Engineer
