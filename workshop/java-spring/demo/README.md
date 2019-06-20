## Run spring-boot app
```
$mvnw spring-boot:run
```

Open url=`http://localhost:8080/actuator/prometheus` in browser

## Create Docker Image
```
$mvnw clean package
$docker image build -t somkiat/springboot .
$docker image push somkiat/springboot
```

## List of APIs
* Success => http://localhost:8080/hello
* Error => http://localhost:8080/hello-error

## Custom metric for prometheus
```
# HELP hello_springboot_total Success case
# TYPE hello_springboot_total counter
hello_springboot_total{result="error",} 7.0
hello_springboot_total{result="success",} 6.0
```