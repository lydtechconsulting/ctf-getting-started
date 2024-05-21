# Component Test Framework - Getting Started

A simple Spring Boot application showcases the component-test-framework for component testing.


The service calls out to a third party service via REST.  This is represented by a standalone wiremock in the component tests.


## The Service

Build Spring Boot application jar, with Java 17:
```
mvn clean install
```

For the component test we deploy the service in a docker container.
Build Docker container:
```
docker build -t ct/ctf-getting-started:latest .
```

Run the Component Test
```
mvn test -Pcomponent
```



Additionally, if you wish to do some investigative work or develop tests against service, you can leave the containers up by adding the `-Dcontainers.stayup` flag to the run tests command 
```
mvn test -Pcomponent -Dcontainers.stayup
```

## Clean Up Commands

- Manual clean up (if left containers up):
```
docker rm -f $(docker ps -aq)
```


## notes / issues
Intermittent mac issue - 'File not found' when starting containers
If the containers do not start it's always worth checking that the file `/var/run/docker.sock` exists.   If the file does not exist, recreate it via``
`sudo ln -s ~/.docker/run/docker.sock /var/run/docker.sock`



The framework is available on Maven Central.  View usage here:  https://github.com/lydtechconsulting/component-test-framework
