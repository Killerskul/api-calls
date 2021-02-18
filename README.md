# API Calls

Simple java project to make API calls

At the current state supports only connections with APIKey and POST/GET operations

## Install

- Using JDK 11 to compile

build with mvn 
```
mvn clean package
```
## Usage

Execute jar file with the following arguments

- <API_URL> <API KEY> <ACTION - GET/POST> <FILE - ONLY FOR POST>

Example for GET:
```java
java -jar api_calls-0.0.1.jar https://localhost/test/api/users i12AwSCVlfWIpoGnmCjjsjka GET
```

Example for POST(support only with json file)
```java
java -jar https://localhost/test/api/users i12AwSCVlfWIpoGnmCjjsjka POST test.json
```


## Contributing
Pull requests are welcome.
