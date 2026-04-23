##  Hospital Management System (GUI)

##  Project Overview

The Hospital Management System is a GUI-based, menu-driven application developed using Java Swing, JDBC, and MySQL.
It enables users to efficiently manage hospital appointments by providing features to book, view, search, and cancel appointments through an interactive interface.

---

##  Features
Book new appointments
View all appointments in table format (JTable)
Search appointments by doctor name
Cancel appointments
User-friendly GUI using Java Swing
Data stored persistently using MySQL

---

##  Technologies Used
Programming Language: Java (Core Java)
GUI Framework: Swing
Database: MySQL
Connectivity: JDBC
IDE: Eclipse
Version Control: Git, GitHub

---

##  Project Architecture

The project follows a layered architecture for better structure and maintainability.
```
HospitalManagementSystem
│
├── DBConnection.java
├── HospitalGUI.java
├── BookAppointment.java
├── ViewAppointments.java
├── SearchDoctor.java
└── CancelAppointment.java
```

---

##  How to Run the Project
Clone the repository:
git clone https://github.com/Neethu-14/HospitalAppointmentSystem.git
Open the project in Eclipse
Add MySQL Connector/J (JDBC Driver) to the project
Create the database and table in MySQL
Update database credentials in DBConnection.java
Run HospitalGUI.java

---

##  Future Enhancements
Add login system (Admin/Patient)
Implement doctor availability scheduling
Add update/edit appointment feature
Improve UI design with advanced styling
