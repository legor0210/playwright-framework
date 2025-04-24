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
