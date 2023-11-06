# SeleniumJava Starter Project

Welcome to the SeleniumJava Starter Project! This guide will help you set up a default Selenium Java project for your web automation testing needs.

## Prerequisites

Before you begin, make sure you have the following prerequisites:

1. **Download ChromeDriver**: Download the appropriate version of ChromeDriver from [https://chromedriver.chromium.org/downloads](https://chromedriver.chromium.org/downloads). Ensure that you choose the version that matches your Chrome browser version. After downloading, extract the ChromeDriver executable to your project's root directory (next to the "pom.xml" file).

## Getting Started

Follow these steps to set up your Selenium Java project:

1. **Create a New Java Class**: Create a new Java class in the "tests" package. This class should extend "BaseTest," just like in the example "ProbnaKlasaTest."

2. **BaseTest Configuration**: The "BaseTest" class is responsible for starting the Chrome browser before each test and closing it afterward. Utilize the JUnit `@Test` annotation and create your test method below. You'll find a "Run Test" button next to the method signature to execute your tests.

3. **Utilize WebDriver and WebDriverWait**: In your test classes, you can make use of the `driver` (as WebDriver) and `wdWait` (as WebDriverWait) variables, which are inherited from the "BaseHelper" class.

4. **Extend BaseHelper**: Ensure that each page or helper class you create extends the "BaseHelper" class.

## Running Your Tests

With your project set up, you can now run your Selenium tests with ease. Simply execute the test methods you've created, and the "BaseTest" class will take care of managing the Chrome browser.

## Acknowledgments

This project is built with a foundation in Selenium WebDriver and JUnit, making it easy for you to get started with web automation testing in Java.

Happy Testing!
