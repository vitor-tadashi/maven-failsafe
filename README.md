# Maven tests with Surefire / Failsafe / OpenClover
Too many articles about Surefire and Failsafe, 
and most people still don't know why Surefire and Failsafe are for
and how to use it.

* Surefire is used for unit tests
* Failsafe is used for integration tests

This project is a clean example how to configure you project with Surefire, 
Failsafe and OpenClover with only necessary dependencies, and how to run your
JUnit tests and generate a code coverage report.

### Running unit tests with Surefire
```
mvn clean test
```

### Running integration tests with Failsafe
Running and checking tests separately
```
mvn failsafe:integration-test
mvn failsafe:verify
```

Running in one command
```
mvn verify
```

### Running unit and integration tests together
```
mvn verify -Dskip.surefire.test=false
```

### Running with OpenClover (for code coverage report)
Running unit tests
```
mvn clean clover:setup test  
```

Running integration tests
```
mvn clover:setup failsafe:integration-test failsafe:verify
```

Generate code coverage
```
mvn clover:aggregate clover:clover
```

Running in one command
```
mvn clean clover:setup verify -Dskip.surefire.test=false clover:aggregate clover:clover
```

### Code coverage report
The code coverage report will be generated inside
`./target/site/clover/dashboard.html`