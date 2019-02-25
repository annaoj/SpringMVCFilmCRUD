## Spring MVC Film C.R.U.D. Project
# Collaborators:
* Anna Jimenez
* Jesse Mena
### Project Description
Overview
Github Repository Name: SpringMVCFilmCRUD

Your application will implement full web-based C.R.U.D. functionality, using Spring MVC and the DAO pattern. The DAO implementation will use JDBC to persist and retrieve data.

## User Story 1
A user can enter a Film's ID and see the details of the film in a web page. If the film is not found, they see an appropriate message.

## User Story 2
A user can choose to add a new film. They can enter all the properties of the film. Their input will be used to create Film object, which the DAO implementation will save in the database. If the insert fails, the user is informed of this.

## User Story 3
When a user retrieves a film, they have the option of deleting it. If they delete the film, it is removed from the database. If the delete fails (such as, due to child records), the user is informed of this.

Note: It is not necessary to be able to delete existing films, which have child records in various tables. Test your delete functionality using new films you've created via User Story 2.
## User Story 4
When a user retrieves a film, they have the option of editing it. If they choose this, all the film's current properties are displayed in a form, allowing them to change any property except the film's ID. When they submit the form, that film's record is updated in the database. If the update fails, the user is informed of this.

## User Story 5
A user can search for films by keyword/pattern in title or description. From the resulting list of films, the user can choose to update or delete a record.

## User Story 6
When a film's details are displayed, its actors and categories are also listed.

Requirements
* The project source is pushed to Github.

* The running application is deployed to Amazon EC2.

* All user stories are implemented.

* The project has a detailed README.md

### Objectives

### Topics/Technologies
* Object-Oriented Design
	* Polymorphism
	* Inheritance
	* Abstraction
	* Encapsulation
* Spring Model View Controller
* MySQL
* Gradle
