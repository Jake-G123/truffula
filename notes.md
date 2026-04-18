# Truffula Notes
As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java
Application for printing a directory tree

## ConsoleColor.java
Enum representing ANSI escape codes for console text colors.

## ColorPrinter.java / ColorPrinterTest.java
A utility class for printing colored text to a PrintStream using ANSI escape codes.

The ColorPrinter allows setting a current color and printing messages in that color to the specified output stream. The color can be reset after each print or kept active based on the provided parameters.
## TruffulaOptions.java / TruffulaOptionsTest.java
Represents configuration options for controlling how a directory tree is displayed.

## TruffulaPrinter.java / TruffulaPrinterTest.java
TruffulaPrinter is responsible for printing a directory tree structure with optional colored output. It supports sorting files and directories in a case-insensitive manner and cycling through colors for visual clarity.

## AlphabeticalFileSorter.java
Utility class for sorting an array of files alphabetically by name, ignoring case differences.

javac -cp lib/junit-platform-console-standalone-1.12.0.jar src/*.java && java -jar lib/junit-platform-console-standalone-1.12.0.jar --class-path src --scan-class-path