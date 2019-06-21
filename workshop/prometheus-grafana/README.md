# Working with manual

## 1. Start Spring Boot application
* Download file and extract from http://bit.ly/2ZCkCli
```
$java -jar demo.jar
```

Open url=http://localhost:8080/actuator/prometheus in browser

### List of APIs
* Success => http://localhost:8080/hello
* Error => http://localhost:8080/hello-error

## 2. Start Prometheus (port 9090)
```
$prometheus
```

## 3. Start Grafana (port 3000)
```
$grafana-server
```

# Working with Docker
```
// Start
$docker-compose up -d

// List of processes/services
$docker-compose ps

// Delete
$docker-compose down
```