# My-Tasks
- IntelliJ (Download Community Edition): https://www.jetbrains.com/idea/download/
- Java 17
- Git: https://git-scm.com/downloads
- Appium Server: https://search.maven.org/search?q=g:io.appium%20AND%20a:java-client
  **Note:** After IntelliJ Installation when you open the project you should install some recommended plugins inside
  IntelliJ: Cucumber for Java, Gherkin.

Framework Structure
---------------------------------------------
Below is the framework structure explanation:

## Main/or Java Folder
Contains five main packages
### Core Package
Contains four packages
*	**“Config”** set appium driver capabilities 
*	**“Driver factory”** has driver initialization
*	**“Hooks”** that is responsible for the setup and teardown methods.

### Pages Package
Contains the page object packages and classes:
*	**CommonPO** this class has the definition for all the common locators
*	Package for every page/ or feature that may have the below classes in case of mobile apps, and only one class in case of web:
*	**Abstract Class** extends the CommonPO class, this class should have the abstract functions and the common locators between iOS and Android.
*	**Android Logic** Implementation Class which extends the Abstract Class and have the android logic implementation for the abstract functions and the android specific locators.
*	**iOS Logic** Implementation Class which extends the Abstract Class and have the iOS logic implementation for the abstract functions and the iOS specific locators.
*	**Note:** You can add react also if you have specific react implementation.

### Utils Package
Contain all the needed utilities.
* **“PropertiesLoader”** class: Contains the properties reader implementation.
-----------
#### **“Base”** package
* **“PageObjectBase”** class: Contains Wrapped needed element actions functionalities across the whole web/ app.
-----------------
#### **“Step Definition Package”** package
*	Contain all the step definitions required for every feature file.
*	In the Step Definition Class You should create a constructor initializing the required pages needed for this step definition based on if condition to switch the pages initilializing Android or iOS according to the driver instance initiated based on the config.properties (This is shown in the example)

-----------------
* **“PropertiesLoader”** class: Contains the properties reader implementation.
* **“Logger”** class: contain the logger implementation.

### Resources Package
*	**“App” folder**: Put here the builds under test. “Android or iOS and you can also add folder for react.”
*	**“config.properties”**: contains the different run configurations (Platform, capabilities location, etc.…)
### TestRunner Class
This class is responsible for getting the cucumber configurations and run specific features accordingly
### Resources Package
* **“Features Folder”**: Should have all the feature files you want to add in the project.


## How to Run the Features
*	You Can run the feature through IntelliJ by right click on any feature or scenario and run it directly.
*	You Can run all the features or filter by tags inside the **“Junit-platform.properties”** class using **“cucumber.filter.tags=”** then run the **“TestRunner”** class
*	You Can run using this command by also adding tags if needed for the run.
*   You Can run using TestNg file too. 

```
mvn clean install -Dcucumber.filter.tags="@tagName"
```

@tagName can be added above any feature or above any scenario in the feature file (Showed in Example.feature)  
