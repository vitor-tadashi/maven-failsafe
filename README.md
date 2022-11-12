# maven-failsafe
mvn clean

mvn test (run unit tests and verify)

mvn failsafe:integration-test (run integration test)

mvn failsafe:verify (verify integration test)

mvn verify -DskipTests

mvn verify -Dskip.surefire.test