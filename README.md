# Anagram checker

Checks if two texts are anagrams of each other

## Prerequisites

Before running this application, ensure that you have the following prerequisite:

- `JAVA_HOME` environment variable set to the path of your JDK installation.

If you don't have Java installed or the `JAVA_HOME` environment variable is not configured, please install the
appropriate JDK for your operating system and set the `JAVA_HOME` variable to the installation directory.

For more information on setting the `JAVA_HOME` environment variable, please refer to the documentation for your
operating system:

- [Setting the JAVA_HOME Environment Variable on macOS and Linux](https://docs.oracle.com/en/java/javase/14/install/installation-jdk-macos-linux-platforms.html#GUID-E7A57AEE-DC6A-4C15-97BF-6C641F95EB1A)
- [Setting the JAVA_HOME Environment Variable on Windows](https://docs.oracle.com/en/java/javase/14/install/installation-jdk-microsoft-windows-platforms.html#GUID-DAF8FA16-8A23-4045-B300-6C2D4426F647)

## Code formatting

On Linux/macOS:

	$ ./mvnw spotless:apply

On Windows:

    > mvnw.cmd spotless:apply

## Building

On Linux/macOS:

	$ ./mvnw clean package -DskipTests

On Windows:

    > mvnw.cmd clean package -DskipTests

## Building & Testing

On Linux/macOS:

	$ ./mvnw clean package 

On Windows:

    > mvnw.cmd clean package 

## Running

On Linux/macOS:

	$ ./mvnw exec:java

On Windows:

    > mvnw.cmd exec:java

![info](https://github.com/borvalcode/anagram/assets/2670196/5c0d513e-e397-439f-9cc0-acd478db492e)
![anagrams](https://github.com/borvalcode/anagram/assets/2670196/70f58da9-62ac-4d30-aefd-ece83e61e5fe)
![not_anagrams](https://github.com/borvalcode/anagram/assets/2670196/d294b976-f5b7-454a-bf24-aff6953a9440)
![anagrams_including_numbers](https://github.com/borvalcode/anagram/assets/2670196/4b53b7d8-61dd-4e91-8e89-a177f0e3b20e)
![not_anagrams_including_numbers](https://github.com/borvalcode/anagram/assets/2670196/d87679cd-1037-4267-b427-84383116db2a)
![anagrams_2](https://github.com/borvalcode/anagram/assets/2670196/004013bb-6ada-4482-b278-41d3b3419676)

## Development

There are three principal layers:

* Domain, which manages business logic, under which we differentiate:
    * Model, that represents all entities, value objects, interfaces (respositories, views, providers...).
    * Command, the entry point to the domain. Actions that use model.
* Application, which uses domain (it can be a desktop/mobile app, web service as REST, RPC...)<br />
  In this particular project, there is a simple desktop app built with JavaFx that calls domain commands.
* Infrastructure, which implements domain interfaces and all their utilities (in this project is not necessary for now)

## Notes

Please BE CAREFUL when running tests, because TestFx robot requires cursor for clicking and writing,
and if you move the cursor tests can fail.

Next step should be to hide this robot somehow and let tests be executed in the background
