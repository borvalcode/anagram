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
