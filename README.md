> This project was created with the kind permission of Pani Od Programowania, who kindly agreed to allow UI testing of her website.
> The tests were developed strictly for educational purposes.

## Selenium Web UI Tests
Automated UI tests for https://paniodprogramowania.pl  
This repository contains a standalone UI test framework (no application code).

---

## Tech stack
- Java 17
- Selenium WebDriver 4.27.0
- TestNG 7.10.2
- Allure Report 2.27.0
- Gradle

---

## Test design
- Page Object Pattern
- Explicit waits only (no implicit waits)
- Desktop viewport enforced for stability
- Screenshots automatically attached on test failure (Allure)
- Allure reports are generated at runtime and not committed
