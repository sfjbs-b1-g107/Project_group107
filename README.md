# Pension Management System

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      About The Project
      <ul>
        <li>Built With</li>
      </ul>
    </li>
    <li>
      Getting Started
    </li>
    <li> To Contribute</li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Given the discouraging record of the traditional pension system and the limited coverage of the private-sector pension schemes, there is need for robust web-based pension fundmanagement system that can handle the pension process efficiently. This work focus on the design and implementation of a web-based pension fund management application to replace the manual system, thus getting rid of the hurdles involved in the traditional pension management process.

The purpose of this program is to develop a system that would keep records of employees or pensioners data including their pension plan, allowances, gratuity, taxes, net pay, rent pay and also calculate the pay of the pensioners taking into consideration the pensioner’s data.

The Project Have the following Services:
## PensionPortalService1 :
This Service is connected via a common H2 DB in which ##PensionPortalService2 loads the data. The Service1 takes the Aadhar/Pan number of the user and returns some calculated amounts based on the request document. In case the Aadhar/PAM is invalid, it returns an error message.
App will run on port: 7090

## PensionPortalService2 :
This Service loads the data into the H2 from a CSV file. It also takes Aadhar/PAN and returns the User details in case of valid data.
App will run on port: 8090

## Data in H2
H2 can be accessed with the url: localhost:8090/h2-console
## Add the details as:

![image](https://user-images.githubusercontent.com/107387367/175063109-c7242628-7b18-4e6a-9fac-a321935700f3.png)


## A sample data is shown below:

![image](https://user-images.githubusercontent.com/107387367/175062655-d985e3e5-4497-493f-98a2-043e2c7a7eaf.png)


<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

Web application is developed in Springboot with microservice architecture. Springboot have the ability to create a stand-alone application with reduce amount of code. Microservice architecture is used to make the application scalable and efficient.

A brief detail of the tech stacks are below:
* Spring boot with microservice architecture
* Spring security for auth service
* JWT validation for extra security
* git for version control.


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To fetch and execute the project, follow the steps:
Steps to pull ->
1. Pull or download the complete project. 
2. Import the project on STS(Spring Tool Suit) as Maven Project.
3. Update the project.
4. Run the Appplication as Run as -> Spring Boot App.

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTRIBUTING -->
## To Contribute

To Contribute/Add features or resolve bugs, Follow the steps below:

1. Pull the Project
2. Create your Feature Branch. (Make a Seperate branch)
3. Commit your Changes in the new branch. 
4. Push to the new Branch
5. Create a Pull Request.

<b>DO NOT MAKE ANY CHANGES TO MAIN BRANCH</b>

<p align="right">(<a href="#top">back to top</a>)</p>
