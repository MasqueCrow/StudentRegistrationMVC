# Student Registration

Developed Student Registration portal for an assignment to learn full-stack Java with Spring Boot

### Functionality
1. Built Student Portal using Spring MVC with Thymeleaf as Java Template to load the View component
2. CRUD operations on Student Model
3. Auto-complete search bar using Ajax
4. Include AOP on methods for logging
5. Simple form validation 

### Setup
To get started with the app, make sure you have Java JDK, mySql, MySQL Workbench and Git installed on your machine

Clone this repo to your machine:
```ruby
$ git clone https://github.com/MasqueCrow/StudentRegistrationMVC
```

Then, create a new database schema in mySql Workbench with the following tables:

**Student**

| Column    | Type         | Nullable
| ------    | -----------  |------ | 
| id        | int(11)      | no    |
| name      | varchar(45)  | yes   | 
| mobile_no | int(11)      | no    |
| address   | varchar(200) | no    |

**User**

| Column    | Type         | Nullable
| ------    | -----------  |------ | 
| id        | int(11)      | no    |
| username  | varchar(45)  | no    | 
| password  | varchar(45)  | no    |

Next, copy/paste the sql queries in [db.sql](/src/main/resources/db.sql) to insert records to both tables

Run Java app and open browser to view the application:
```ruby
localhost:8888/student
```
