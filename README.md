RevatureGroup1_Project2

Project Description:

A big data e-commerce application that uses a generator to create a CSV file with 10,000 rows related to customer order data from websites in different countries. The data from the CSV file can then be analyzed through specific queries requested by a marketing department. A visualization tool is then used to graphically display the output for each query.

Technologies Used:

• Scala - 2.11.12

• Java 1.8.1 

• Spark – 2.4.6

• Hadoop – 2.6

• Hive – 2.3.9

• Sbt – 0.13


Features:

• A Generator Object to create a CSV file containing 10,000 entities of ecommerce data.

• A DatabaseManager class for creating a SparkSession and reading information from the generated CSV file into a DataFrame.

• A DatabaseAnalysis class to create functions that handle specific queries which are then referenced in the DatabaseManager class.

• A DatabaseMenu object that accepts user input to select from one of four marketing questions.

• A LoginMenu object to validate username/password which will then call the DatabaseMenu upon a successful check for credentials.

• A Main object as a simple option to run the application.

To-do list:

• Utilizing abstraction within classes

• Execute more queries for an even more detailed analysis! 


Contributors:

• Morgan Simmons

• Sherrell Jones

• Abnel Negron

• Tony Wilkins

• Normand Jean (Team Lead)
