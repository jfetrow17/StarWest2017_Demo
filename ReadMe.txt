************************************************************************************
* Read me to setup and run the model based testing demo from StarWest 2017         *
************************************************************************************

You will need the following to be able to execute the demo provided here:
- Java 7 or higher
- Eclipse
- Chrome
- Chromedriver for you version of Chrome:  https://sites.google.com/a/chromium.org/chromedriver/downloads
- Selenium webdriver
- TestNG
- Graphwalker
- yED 

- Preq:  you must already have java installed.

1. Download and place the Web_Flight folder in your at the root of your c drive (the automation scripts expect it to be there)
2. Create a folder in the Web_flight folder called "TestLogs"
	*  Test loggin will be written to this location
2. Install Eclipse
3. Set up a Java project in eclipse
4. Import the src folder into that project.
	* make sure that StarWestFlightSearch ends up under the src folder, otherwise move it under src
5. Add the following external jars to you project:
	-  graphwalker-cli-3.4.2.jar
	-  selenium-server-standalone-2.43.1.jar 
	-  org.testng.eclipse_6.8.6.20141201_2240.jar
	
	*  for best results use the jars with this readme

6.  place the chromedriver.exe in C:/Web_Flight/ (the automation script expects it to be here)
7.  Execute one of the following from your java project
	-  Demonstration_Gen.java (this was executed during StarWest)
	-  Hotel_Search.java (this was executed during starwest)
	-  SystemRegression_Gen.java (Not executed at StarWest, Warning!!! this takes hours to execute)

Note:  please make sure all of the path are correct in you java project. The tests will fail to run if they are no correct.
	
________________________________________________________________________________________

Information about the project in eclipse
-  The selenium objects from the html pages are stored in the src folder in ObjectLibrary.java
-  The files post fixed with "_API" contain all of the objects that in the graphml.

Note:  These materials are for demonstration purposes only, there are still bugs both the html javascript, and possibly the test code itself.  Their intent is to provide 
an idea of how to potentially implement a model-based test automation framework.

	
