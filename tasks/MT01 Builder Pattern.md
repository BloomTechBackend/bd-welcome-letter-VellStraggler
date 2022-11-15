## Mastery Task 1: 

We've been using a single full-sized constructor to initiate our Models.
This worked fine at first, but as the Employee class grew and the number
of optional fields increased, we needed a better solution. We've decided
for this and for future projects that we will be implementing the 
Builder Pattern for object instantiation.

### Implement the Builder Pattern

Refactor the `Company` and `Employee` class so that they each have no 
**public** constructors, and so that each can be instantiated using
an internally defined `Builder` class.

### Validate the Employee Objects

When an `Employee` object is built, it should first check that the `firstname`
and the `company` are not `null`. If they are we need to alert the user
somehow and stop execution of the build method. To do so we will throw 
a generic `RuntimeException` with a message informing the user that these
fields are required.

### Completion

Run the gradle command:

`./gradlew -q clean :test --tests 'com.bloomtech.welcomeletter.MasteryTask_1*'`

and ensure all tests pass.

