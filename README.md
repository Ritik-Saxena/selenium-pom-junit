<img alt="selenium logo" src="https://github.com/user-attachments/assets/892665fb-2f28-4f2d-be8d-155da5c14379" align="right" style: height=150 width=150 />


# Selenium POM using JUnit: Element Interactions <br>
> Connect with me on <a href='https://www.linkedin.com/in/ritik-saxena'>LinkedIn</a>

<br>


### 📝 **About the Project**  


This project is a **Selenium-based test automation framework** implemented using the **Page Object Model (POM)** to ensure modularity, reusability, and maintainability of test scripts. It covers **UI automation for various web interactions**, including **login functionality, alerts, drag-and-drop, dropdowns, frames, multiple windows, and web tables**.  

🔹 **Key Features:**  
- 🚀 **Page Object Model (POM):** Ensures a structured and scalable test design.  
- 🛠 **Utility-Driven Approach:** Uses `ElementUtils.java`, `WaitUtils.java`, `ExcelUtils.java`, `LogUtils.java`, `ScreenshotUtils.java`, `BrowserUtils.java`, and `ConfigReader.java` for efficient automation.  
- 📊 **Data-Driven Testing:** Implements `ExcelUtils.java` to parameterize test data dynamically.  
- 📸 **Automated Screenshots:** Captures screenshots on test failures using `ScreenshotUtils.java`.  
- 📝 **Logging & Reporting:** Uses `LogUtils.java` to track test execution status.  
- 🔄 **Regression Testing:** Implemented **regression suite** to validate existing functionalities after updates.  
- 🏗 **CI/CD Integration:** Configured **Jenkins Pipeline** to automate regression test execution.  

This framework ensures **robust test automation, reduces manual efforts, and integrates seamlessly into CI/CD pipelines for continuous testing.** 🚀✅



<br>


## Folder Structure
```
selenium-pom/
│── logs/
│   ├── test.log
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/
│   │   │   │   ├── AlertPage.java
│   │   │   │   ├── DragAndDropPage.java
│   │   │   │   ├── DropdownPage.java
│   │   │   │   ├── FramesPage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── MulipleWindowsPage.java
│   │   │   │   ├── WebTablePage.java
│   │   │   ├── utils/
│   │   │   │   ├── BrowserUtils.java
│   │   │   │   ├── ConfigReader.java
│   │   │   │   ├── ElementUtils.java
│   │   │   │   ├── ExcelUtils.java
│   │   │   │   ├── LogUtils.java
│   │   │   │   ├── ScreenshotUtils.java
│   │   │   │   ├── WaitUtils.java
│   │   ├── resources/
│   │   │   ├── LoginTestData.xlsx
│   │   │   ├── config.properties
│   │   │   ├── log4j2.xml
│   ├── test/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   ├── BaseTest.java
│   │   │   ├── tests/
│   │   │   │   ├── RegressionsTestSuite.java
│   │   │   │   ├── AlertTest.java
│   │   │   │   ├── DragAndDropTest.java
│   │   │   │   ├── DropdownTest.java
│   │   │   │   ├── FramesTest.java
│   │   │   │   ├── LoginTest.java
│   │   │   │   ├── MulipleWindowsTest.java
│   │   │   │   ├── WebTableTest.java
│── target/
│   ├── screenshots/
│   │   ├── loginSuccess.png
│── Jenkinsfile
│── pom.xml
```


## **Common Automation Test Implementation Points** 🚀  

These are the common best practices followed across all test cases:

* **Implemented Page Object Model (POM)** to maintain modularity and separation of concerns.
* **Utilized explicit waits (WaitUtils) and ElementUtils** to ensure elements are properly loaded before interaction.
* **Performed data-driven testing** (where applicable) to enhance test coverage and reusability.
* **Implemented assertions** to validate expected behaviors for UI elements and actions.
* **Used logging (LogUtils)** to track test execution status for better debugging and reporting.
* **Captured screenshots (ScreenshotUtils)** for key test scenarios like successful actions or failures.
* **Ensured structured test execution flow** by using proper setup methods before each test.
* **Utilized essential utilities** (`ElementUtils`, `WaitUtils`, `ExcelUtils`, `LogUtils`, `ScreenshotUtils`, `BrowserUtils`, `ConfigReader`) to enhance test automation efficiency, ensuring reliable element interactions, explicit waits, data-driven testing, logging, screenshot capturing, and configuration management.

<br>

## Test Preview
### 🔑 Login Test

* Worked with text field interaction using `enterUsername()` and `enterPassword()` methods.
* Performed **data parameterization for login credentials using Apache POI** via `ExcelUtils`.
* Ensured secure credential retrieval via `ConfigReader` utility for application properties.
* Validated login functionality for both **valid and invalid credentials**.
* Implemented a **dynamic test execution flow using data-driven testing** via Excel.
* Ensured **proper test reporting using logs and status messages**.

https://github.com/user-attachments/assets/7bb2c04e-a689-4e82-b700-4e29f1dce158

<br>

### ⚠️ Alert Test

* Automated **JavaScript alert handling**, including simple, confirmation, and prompt alerts.
* Used **Selenium's alert interface** to accept, dismiss, and send text to alerts.
* **Validated alert responses using assertions** to ensure expected results.
* Tested **multiple alert behaviors**, such as **OK and Cancel actions for confirmation alerts**.
* Performed **text input automation for JavaScript prompt** alerts.

https://github.com/user-attachments/assets/aa887aa5-ef99-4948-a4d8-d63923d4e7b0

<br>

### 🖱 Drag And Drop Test

* **Automated drag-and-drop** functionality using Selenium’s **`Actions` class**.
* Performed element interactions using Actions class for smooth drag-and-drop execution.
* Validated UI behavior by simulating user actions programmatically.

https://github.com/user-attachments/assets/b8e6cf5a-0ab1-4961-a354-29c7352a77e8

<br>

### 📌 Dropdown Test

* **Automated dropdown selection** testing using Selenium’s **`Select` class**.
* Performed dropdown selection using multiple methods:
  * **By value**
  * **By visible text**
  * **By index**
* **Validated selected dropdown options using assertions** to ensure correct selection.
* Created **structured and reusable methods** for dropdown interactions to improve maintainability.
* **Logged dropdown selection actions** using `LogUtils` for better test tracking.

https://github.com/user-attachments/assets/28531409-6134-440c-8056-0c38c2e1e5b2

<br>

### 🖼 Frames Test
* Automated **frame handling and switching** using Selenium’s ```switchTo().frame()``` methods.
* Ensured **proper frame navigation** and interactions with embedded elements inside frames..

https://github.com/user-attachments/assets/530b4f11-46e3-4fe3-ba24-669649d9cbbd

<br>

### 🪟 Muliple Windows Test
* Automated **multiple window handling** using Selenium’s ```switchTo().window()``` methods.
* Performed **dynamic window switching** by both tab number and window title.
* Validated UI behavior by **asserting window titles after switching**.
* Implemented **efficient window management by allowing selective and bulk window closures**.

https://github.com/user-attachments/assets/5cb11e22-5312-44eb-b84c-25591116ae7b

<br>

### 📊 WebTable Test
* Automated **web table validation** by retrieving and verifying column headers dynamically.
* **Extracted table data dynamically** for structured and efficient data retrieval.
* **Validated column headers** against expected values to ensure correct table structure.
* Implemented **a reusable method to fetch all rows** for scalable test cases.

https://github.com/user-attachments/assets/09f8a8f6-96f4-48c8-aa2f-dc5c44ca49dd


<br>

## Detailed Logs
Implemented custom logging to track test execution, including **INFO**, **ERROR**, and **WARNING** logs. These logs provide visibility into test execution flow, failures, and key actions performed during test runs.

### 📄 Sample Logs (`logs/test.log`)
```
2025-03-05 07:41:48 [main] INFO  utils.LogUtils - [tests.LoginTest.testValidLogin:37] - Login successful: You logged into a secure area!
2025-03-05 07:41:52 [main] INFO  utils.LogUtils - [tests.LoginTest.testLoginWithExcelData:80] - Starting login test with Excel data...
2025-03-05 07:41:54 [main] INFO  utils.LogUtils - [tests.LoginTest.testLoginWithExcelData:94] - Attempting login for user: demo
2025-03-05 07:41:55 [main] ERROR utils.LogUtils - [tests.LoginTest.testLoginWithExcelData:106] - Failed to login!
2025-03-05 07:41:55 [main] INFO  utils.LogUtils - [tests.LoginTest.testLoginWithExcelData:94] - Attempting login for user: tomsmith
2025-03-05 07:41:56 [main] INFO  utils.LogUtils - [tests.LoginTest.testLoginWithExcelData:104] - Login Successful!
2025-03-05 07:41:56 [main] INFO  utils.LogUtils - [tests.LoginTest.testLoginWithExcelData:113] - Excel test completed. Data saved.
2025-03-05 07:42:03 [main] INFO  utils.LogUtils - [tests.LoginTest.testValidLoginAndTakeScreenshot:67] - You logged into a secure area!
2025-03-05 07:42:03 [main] INFO  utils.LogUtils - [tests.LoginTest.testValidLoginAndTakeScreenshot:71] - Login successful: You logged into a secure area!
2025-03-05 07:42:03 [main] INFO  utils.LogUtils - [utils.ScreenshotUtils.takeScreenshot:21] - Screenshot taken successfully!
2025-03-05 07:42:10 [main] INFO  utils.LogUtils - [tests.LoginTest.testInvalidLogin:53] - Login failed as expected: Your username is invalid!
2025-03-05 07:43:10 [main] INFO  utils.LogUtils - [tests.DropdownTest.validateDropdown:31] - Selected dropdown option: Option 1
2025-03-05 07:43:11 [main] INFO  utils.LogUtils - [tests.DropdownTest.validateDropdown:36] - Selected dropdown option: Option 2
2025-03-05 07:43:11 [main] INFO  utils.LogUtils - [tests.DropdownTest.validateDropdown:41] - Selected dropdown option: Option 1
```

<br>

## CI/CD Integration using Jenkins

Below are the pipeline stages performed for the project.

1. **Checkout Code:** Pulls the latest test scripts from GitHub.
2. **Set Up Dependencies:** Runs `mvn clean install -DskipTests` to set up project dependencies.
3. **Regression Test Execution:**
   * Executes `mvn test -Dtest=RegressionTestSuite`.
   * Runs all test classes listed under RegressionTestSuite.
5. **Reporting and Archiving the artifact:**
    * JUnit Test Reporting: Collects test execution results from `surefire-reports`.
    * Artifact Archiving: Stores test reports for future reference.

![Jenkins build](https://github.com/user-attachments/assets/b8b689ec-7845-4a04-9bf9-bc15e65e1fab)

![Jenkins Blue Ocean](https://github.com/user-attachments/assets/5e5cfff0-d6a1-4a5f-af2b-af5c84bc445d)

--- 
If you like this repository, do <img src="https://user-images.githubusercontent.com/62079355/200077014-f3e95bba-57a6-4c7a-b26a-212bf18e5162.png" width=25 height=25> and <img src="https://user-images.githubusercontent.com/62079355/220893415-ea2015e9-6df6-4de2-ab66-041a3f890be2.png" width=25 height=25> the repo for more amazing stuff coming soon.

---
[![GitHub stars](https://img.shields.io/github/stars/Ritik-Saxena/selenium-pom-junit?style=social)](https://github.com/Ritik-Saxena/selenium-pom-junit)
[![GitHub followers](https://img.shields.io/github/followers/Ritik-Saxena?style=social)](https://github.com/Ritik-Saxena?tab=followers)
[![GitHub forks](https://img.shields.io/github/forks/Ritik-Saxena/selenium-pom-junit?style=social)](https://github.com/Ritik-Saxena/selenium-pom-junit)
[![GitHub watchers](https://img.shields.io/github/watchers/Ritik-Saxena/selenium-pom-junit?style=social)](https://github.com/Ritik-Saxena/selenium-pom-junit)

