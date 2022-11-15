## Mastery Task 2: 

In order to visualize and share with others how this app is intended 
to work, we need to create class and sequence UML diagrams. By now
you should have PlantUML added as a plugin to your IntelliJ IDE. We
will be using this to create our diagrams.

Each of these puml files are created for you already in the src/resources
folder.

### Implement a Class Diagram for the Models

Create a class diagram showing each class in the `models` package,
their properties (excluding `maxId`), and their methods. (You may omit getters).
Indicate the type and access level of each property and method you include.

Also, indicate the relationships between the classes including the Role enum.
You can use `--` as the relationship type beteen Roles and Employees.

### Implement a Class Diagrams for the Services

Create a class diagram showing the chain of dependencies stemming from
the `EmployeeService` class. Include methods, their access levels, and use
the `-->` relationship arrow to indicate a dependency between two classes.

### Create a Sequence Diagram for the Operation of Sending a Welcome Letter

The actors are provided for you in the `CreateWelcomeLetterSD.puml` starting
file. Assume `App` calls the `sendFormToEmployeeWithId` method. 

Indicate the name of each method called, and the class that method returns
to. (Some methods may return to the same class from which they were called).

Indicate as well the return data type for non-`void` methods.

Finally, include any alternate routes that may occur where an exception is
thrown.

### Completion

Run the gradle command:

`./gradlew -q clean :test --tests 'com.bloomtech.welcomeletter.MasteryTask_2*'`

and ensure all tests pass.

