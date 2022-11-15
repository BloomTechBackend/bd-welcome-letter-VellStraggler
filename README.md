## Welcome Letter Service

In this project, you will be building a helpful microservice app that keeps a 
record of employees and generates a welcome message to send new employees on their
first day.

### Starting Code

We have a `Datasource` object with information of the `Employee`s and 
`Company`s that we will seed our app with. Our application can extract 
employee data from the `Datasource` using the `EmployeeRepository`. You
may not access data from the datasource without going through a repository.

Our data is represented in Java Classes called Models. We have models for
employees, companies, and roles. You will be modifying the `Company` and 
`Employee` class in this project, the `Role` enum requires no modifications.

The primary action performed by this app will be to generate a welcome letter
for a given employee. The `EmployeeService` is responsible for initiating that
action, and the `FormLetterService` contains the business logic required.
The `FormLetterService` makes use of the currently (mostly) empty `FileManager`
class which you will need to implement.

Inside of the `src/resources` folder, you will find a `LetterTemplate.txt` file.
The `FormLetterService` will read in this file, replace the textfields indicated
by the `[]`s with the appropriate data, and output a welcome letter to the
`src/resources/out` directory.

### Tasks

* Implement the Builder Pattern for object instantiation of our Models.
* Create Class Diagrams for our Models and a Sequence Diagram for the
`sendFormToEmployeeWithId` operation (called from `App`).
* Implement the File I/O Logic for the `FileManager` class. 

*Note: there is no Mastery Task 3 for this Sprint.*

### Completion

Running `./gradlew -q clean :test` passes and the correct form letter 
appears in the out directory.