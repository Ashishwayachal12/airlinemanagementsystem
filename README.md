# Airline Management System

This is a **mini-project** developed in **Java**. It serves as an airline management system, incorporating basic functionalities to manage flights, passengers, and bookings.

## Features
- User-friendly interface created using **Java Swing** and **AWT**.
- Backend powered by **MySQL** for reliable data storage and management.
- Key operations include:
  - Managing flight schedules.
  - Adding and viewing passenger information.
  - Booking and canceling flights.

## Technologies Used
- **Java**: Programming language for application development.
- **Java Swing & AWT**: For designing the graphical user interface (GUI).
- **MySQL**: Database for storing application data.

## Prerequisites
Before running the application, ensure you have:
1. **Java Development Kit (JDK)** installed.
2. **MySQL** server set up.
3. A Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans).

## Database Setup
1. Create a MySQL database using the provided SQL script (if applicable).
2. Update the database connection details in the application's source code.

## How to Run
1. Clone the repository:
   ```bash
   git clone <https://github.com/Ashishwayachal12/airlinemanagementsystem.git>
2.Open the project in your IDE.(ex:-NetBeans)

## Ensure the database is configured and running.
   Database All code
   create database airlinemanagementSystem;

use airlinemanagementSystem;
show tables;

create table login(username varchar(20),password varchar(20));

insert into login values("admin","admin");
insert into login values("Ashish","123");

select * from login;

create  table passenger (name varchar(20),
nationality varchar(20),
phone varchar(10),address varchar(40),
aadhar varchar(12),
gender varchar(20));

select * from passenger;

create table flight(f_code varchar(20) primary key,
f_name varchar(20),
source varchar(20),
destination varchar(30));

describe flight;

insert into flight values("1000","AI-1211","Delhi","Mumbai");
INSERT INTO flight VALUES
("1001", "AI-1212", "Delhi", "Goa"),
("1002", "AI-1234", "Mumbai", "Delhi"),
("1003", "AI-5678", "Chennai", "Kolkata"),
("1004", "AI-9101", "Bangalore", "Hyderabad"),
("1005", "AI-1122", "Hyderabad", "Bangalore"),
("1006", "AI-3344", "Kolkata", "Chennai"),
("1007", "AI-5566", "Delhi", "Bangalore"),
("1008", "AI-7788", "Mumbai", "Kolkata"),
("1009", "AI-9900", "Kolkata", "Delhi"),
("1010", "AI-1010", "Chennai", "Mumbai"),
("1011", "AI-1213", "Delhi", "Hyderabad"),
("1012", "AI-1314", "Hyderabad", "Delhi"),
("1013", "AI-1516", "Mumbai", "Chennai"),
("1014", "AI-1718", "Chennai", "Bangalore"),
("1015", "AI-1920", "Bangalore", "Delhi"),
("1016", "AI-2021", "Hyderabad", "Kolkata"),
("1017", "AI-2223", "Kolkata", "Bangalore"),
("1018", "AI-2425", "Delhi", "Chennai"),
("1019", "AI-2627", "Mumbai", "Hyderabad"),
("1020", "AI-2829", "Chennai", "Delhi"),
("1021", "AI-3031", "Bangalore", "Mumbai"),
("1022", "AI-3233", "Kolkata", "Hyderabad"),
("1023", "AI-3435", "Delhi", "Mumbai"),
("1024", "AI-3637", "Mumbai", "Kolkata"),
("1025", "AI-3839", "Chennai", "Hyderabad"),
("1026", "AI-4041", "Bangalore", "Kolkata"),
("1027", "AI-4243", "Hyderabad", "Chennai"),
("1028", "AI-4445", "Kolkata", "Mumbai"),
("1029", "AI-4647", "Delhi", "Bangalore"),
("1030", "AI-4849", "Mumbai", "Delhi"),
("1031", "AI-5051", "Chennai", "Kolkata"),
("1032", "AI-5253", "Bangalore", "Hyderabad"),
("1033", "AI-5455", "Hyderabad", "Delhi"),
("1034", "AI-5657", "Kolkata", "Bangalore"),
("1035", "AI-5859", "Delhi", "Hyderabad"),
("1036", "AI-6061", "Mumbai", "Chennai"),
("1037", "AI-6263", "Chennai", "Delhi"),
("1038", "AI-6465", "Bangalore", "Mumbai"),
("1039", "AI-6667", "Hyderabad", "Kolkata"),
("1040", "AI-6869", "Kolkata", "Chennai");



SET SQL_SAFE_UPDATES = 0;

DELETE FROM flight
WHERE f_code = "1001" AND f_name = "AI-1212" AND source = "Delhi" AND destination = "Mumbai";

SET SQL_SAFE_UPDATES = 1;

ALTER TABLE flight
MODIFY COLUMN f_code VARCHAR(20) NOT NULL;



select * from flight;



CREATE TABLE reservation (
    PNR VARCHAR(20) PRIMARY KEY,
    ticket_number VARCHAR(15),
    aadhar VARCHAR(12),
    name VARCHAR(50),
    address VARCHAR(100),
    nationality VARCHAR(30),
    flight_name VARCHAR(50),
    flight_code VARCHAR(20),
    gender VARCHAR(10),
    source VARCHAR(50),
    destination VARCHAR(50),
    departure_date date
);
ALTER TABLE reservation
MODIFY departure_date VARCHAR(20);

describe reservation;

select * from reservation

CREATE TABLE cancel (
    pnr VARCHAR(20),
    name VARCHAR(40),
    cancelno VARCHAR(20),
    fcode VARCHAR(20),
    ddate VARCHAR(30)
);

select * from cancel;

4. Compile and run the project.
   ```bash
   git clone < run in Login page>


## Screenshots
1. Login Page :user name:Ashish and password: Ashish@99

  ![Screenshot 2024-11-26 184004](https://github.com/user-attachments/assets/25ce9771-3bcc-4824-abdd-c9d8a115007d)

2.Home page:-

  ![Screenshot 2024-11-26 184253](https://github.com/user-attachments/assets/56144e23-ecba-48b5-9473-121572a814d1)
  
3.Flight Information:-

![image](https://github.com/user-attachments/assets/98acca69-055c-4c15-af58-b83d15f08d60)

4.Filght Details:-

![Screenshot 2024-11-26 184617](https://github.com/user-attachments/assets/bb474d2b-3057-4f0e-a828-9fb40548efad)


5.Add Customer Details:-

 ![Screenshot 2024-11-26 184740](https://github.com/user-attachments/assets/8c8cfda8-733e-411a-8209-2da404d0b66d)

  
6.Book Flight:-

![Screenshot 2024-11-26 185429](https://github.com/user-attachments/assets/3469c968-352f-4567-b691-083a77db1681)

![Screenshot 2024-11-26 185521](https://github.com/user-attachments/assets/5a3e90c8-2126-437f-b08b-b1aee05e9960)

7.JourneyDetails:-

![Screenshot 2024-11-26 185712](https://github.com/user-attachments/assets/462ca904-41ce-4277-b40d-c0822b050851)


8.Bording Pass:-

![Screenshot 2024-11-26 185814](https://github.com/user-attachments/assets/ddceaced-3c56-45a9-8a68-1e4775ab5d15)


9.Cancel Flight:-

![Screenshot 2024-11-26 185915](https://github.com/user-attachments/assets/eaf54fbc-ab30-4722-b21a-d1e2d1fb8c59)



## This project is open-source. Feel free to use, modify, and share.







  

     
    
