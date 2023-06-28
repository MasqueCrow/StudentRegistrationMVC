# Student Registration

Developed Student Registration portal for an assignment to learn full-stack Java with Spring Boot

### Functionality
1. Built Student Portal using Spring MVC with Thymeleaf as Java Template to load the View component
2. CRUD operations on Student model
3. Auto-complete search bar using Ajax
4. Include AOP on methods for logging
5. Simple form validation

### Screenshot

#### Login
![Login](/src/main/resources/ss/login.png?raw=true "Login")

#### Display All Student Detail
![Home](/src/main/resources/ss/home.png?raw=true "Home")

#### Ajax Filter
![Ajax](/src/main/resources/ss/filter_stud.png?raw=true "Filter")

#### Register Student
![Register Student](/src/main/resources/ss/reg_stud.png?raw=true "Register Student")

#### Update Student Detail
![Update Student](/src/main/resources/ss/update_stud_detail.png?raw=true "Update Student")

#### Delete Student
![Delete Student](/src/main/resources/ss/del_stud.png?raw=true "Delete Student")


### Setup
To get started with the app, make sure you have Java JDK, mySql, MySQL Workbench and Git installed on your machine

Clone this repo to your machine:
```ruby
$ git clone https://github.com/MasqueCrow/StudentRegistrationMVC
```

Next, install and update Maven dependencies defined in pom.xml 


Then, create a new database schema in mySql Workbench with the following tables:

**Student**

| Column    | Type         | Nullable |
| --------- | -----------  |--------  | 
| id        | int(11)      | no       |
| name      | varchar(45)  | no       | 
| mobile_no | int(11)      | yes      |
| city      | varchar(200) | yes      |

**Subject**

| Column    | Type         | Nullable |
| --------- | -----------  |--------  | 
| id        | int(11)      | no       |
| name      | varchar(45)  | no       | 

**Student_Subject**

| Column     | Type         | Nullable |
| ---------  | -----------  |--------  | 
| student_id | int(11)      | no       |
| subject_id | int(11)      | no       | 

**User**

| Column    | Type         | Nullable
| --------- | -----------  |------ | 
| id        | int(11)      | no    |
| username  | varchar(45)  | no    | 
| password  | varchar(45)  | no    |


Copy and Paste SQL queries in [db.sql](/src/main/resources/db.sql) to insert records to both tables

Run Java app and open browser to view the application:
```ruby
localhost:8005/student
```
