# Credit Card Number Verification + Generic File Reader-Writer


This application is built in Spring Boot using Maven as a part of SW System Engineering [CMPE202] individual project assignment. This is not a web application. Reason for using Sprint Boot is, I am using the same web framework for group project also. This application has 4 modules. These are designed in such a generic way that in future it is extendible to support with minimal changes:
- 1. Different types of file by extending classes [now only supports csv/xml/json] 
- 2. Different attributes of Input/Output file
- 3. Different validation for different types of credit cards
- 4. Different types of credit card.

> Download from github and unzip the folder/code 

> ** All the validations and contraints confirmed my Professor/TA are applicable here.
----------------------------------------------------------------
## **Design Part 1:**
> Class Diagram Location: __"individual-project-s-c-soma\design\design_part_1\"__
## **Design Part 2:**
> Class Diagram Location: __"individual-project-s-c-soma\design\design_part_2\"__
----------------------------------------------------------------
# **To Build the application: (optional)**
1. From cmd go to location: __"individual-project-s-c-soma-master\application_code\application_code\"__
2. Build the code using following command: **[windows machine]**
```
mvnw clean install
```

Build the code using following command: **[mac machine]**
```
./mvnw clean install
```
----------------------------------------------------------------
# **To Run the application:** : 
There are two ways to run this application from command line. Following are the option and steps for windows and mac machine. 

## **Procedure A:** Using Maven Command line

1. Put input file inside: __"individual-project-s-c-soma-master\application_code\sample_input_output_files"__
2. From cmd go to location: __"individual-project-s-c-soma-master\application_code\"__
3. From cmd run the following command: **[windows machine]**
```
mvnw spring-boot:run
```
From cmd run the following command: **[mac machine]**
```
./mvnw spring-boot:run
```
4. Output file will be created here: __"individual-project-s-c-soma-master\application_code\sample_input_output_files"__
5. Appropriate object creation of different CreditCard types are printed in console/cmd

## **Procedure B:** Running Jar file from Command line/Terminal

1. Put file input inside folder: __"individual-project-s-c-soma-master\application_code\sample_input_output_files"__ 
2. From cmd go to location: __"individual-project-s-c-soma-master\application_code\application_code\"__
3. Build the code using following command: **[windows machine]**
```
mvnw clean install
```
Build the code using following command: **[mac machine]**
```
./mvnw clean install
```
4. From cmd run the following command: 
```
java -jar ./target/credit_card-0.0.1-SNAPSHOT.jar
```
5. Output file will be created here: __"individual-project-s-c-soma-master\application_code\application_code\sample_input_output_files"__
6. Appropriate object creation of different CreditCard types are printed in console/cmd

## **Procedure C:** Directly from the editor [I have used VS Code]
1. Open folder __"individual-project-s-c-soma-master\application_code\application_code\"__ from editor
2. Run the main program from file __"CreditCardApplication.java"__
3. Output file will be created here: __"individual-project-s-c-soma-master\application_code\application_code\sample_input_output_files"__
4. Appropriate object creation of different CreditCard types are printed in console/cmd
---------------------------------------------------------------
# **To run Test Cases from Comman Line (Using Maven):**

1. from cmd go to location: __"individual-project-s-c-soma-master\application_code\application_code\"__
2. Run the following command: **[windows machine]**
```
mvnw test
```
Run the following command: **[mac machine]**
```
./mvnw test
```
Spring initializer: https://start.spring.io/
