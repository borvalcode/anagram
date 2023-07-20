# Anagram checker

Checks if two texts are anagrams of each other

## Format code

	$ mvn spotless:apply

## Building

	$ mvn clean package -DskipTests

## Building & Testing

	$ mvn clean package

## Running

	$ mvn exec:java

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
