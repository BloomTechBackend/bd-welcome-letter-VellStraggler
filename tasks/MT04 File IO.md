## Mastery Task 4: 

In order for our `FormLetterService` to generate a welcome letter, it will need to
go through the currently unimplemented `FileManager` class. An instance of this class
should be able to read text from a file and write text to a file.

### Implement the getTextFromFile method

This method takes the name of a file as input, and should then search for a file at
the path: `src/resources/{filename}.txt`.
If it cannot find the file it should throw a `FileNotFoundException`.
Otherwise, it should store the file's contents exactly into a String and return them.

Note: some methods of reading a file may cause it to truncate the newline character
`\n`. In this case you may need to add a `\n` to the end of each line.

*You can print your returned String to the console and see if the line indentation 
is working properly*.

### Implement the FormLetterService

This class has a single method `generateWelcomeLetter` which takes an `Employee` as
input.

This method needs to request the template data from `LetterTemplate.txt` in the 
resources directory, from the `FileManager`. 

Then it should use the String `.replace()` method to replace any `[]`ed text with
its correct value.

Finally, the finalized String should be passed to the `FileManager`s `writeTextToFile`
method.

### Implement the writeTextToFile method

After the `FormLetterService` updates the template string to the final result, your
`FileManager` need to write that data exactly to the output file path: 
`src/resources/out/{filename}.txt`.

### Completion

Run the gradle command:

`./gradlew -q clean :test --tests 'com.bloomtech.welcomeletter.MasteryTask_4*'`

and ensure all tests pass.

