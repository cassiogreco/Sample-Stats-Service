# Sample Stats Service

This service is a sample Java8 with Springboot stats service which accepts "transactions" up to 60 seconds ago and returns basic statistics from the last 60 seconds worth of transactions.

No database is used so everything is in-memory.

## Dependencies
This project is written in Java 8 with Springboot and uses Maven for automating builds and dependencies.
Make sure you have Java version 1.8 installed and the `mvn` command in your path.

For installing Maven, follow [this link](https://maven.apache.org/install.html)

After having everything installed, run `mvn install` for maven to install the project's dependencies.

## Building
Run `mvn compile`

## Testing
Run `mvn test`

## Running
Run `mvn spring-boot:run`. The server should start on port `8080`

- To send transactions, make POST calls to `/transactions` and send in the `timestamp` in milliseconds and the `amount`.
An example curl call:
```
curl -X POST http://localhost:8080/transactions -i -H "Content-Type: application/json" --data '{"amount":"10.0","timestamp":"1529880000000"}'
```

- To fetch the statistics, make a GET call to `/statistics`
An example curl call:
```
curl http://localhost:8080/statistics -i
```
