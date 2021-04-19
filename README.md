# bdd-test-framework-smartbox
Framework to test adding a box to the shopping cart

-----
Tools
-----
- Maven
- Cucumber

-------------
Configuration
-------------
This project can handle configuration for the following environments: 
- DEV
- INT
- PROD

-------
Reports
-------
Reports are generated automatically and can be located in the following folder:\
/target/cucumber-reports/index.html

----------------
Folder Structure
----------------
- /src/main/java/core contains the DriverFactory, JSONDataProvider and TestConfig classes
- /src/main/resources/config contains the .properties files containing environment configuration details
- /src/main/resources/testdata contains the input test data in .json format
- /src/test/java/features contains the feature file AddBoxToCart.feature
- /src/test/java/pages contains the Page Object Model classes
- /src/test/java/runner contains the TestRunner class from where the tests can be run
- /src/test/java/step_definitions contains the step defintion files

-------------------
Running the Program
-------------------
The program can be run the following ways:
- Run the command 'mvn test -Dbrowser=chrome -Denv=int' from the terminal
- Through /src/test/java/runner/TestRunner.java: set environment variables browser=chrome;env=int and click the green arrows at 'public class TestRunner'
