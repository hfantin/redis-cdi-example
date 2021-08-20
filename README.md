# Example of cdi project with redis

## Test

- `docker-compose up -d`
- `curl -X POST http://localhost:8080/redis-cdi-example/api/redis/{key} -d value`
- `curl -X GET http://localhost:8080/redis-cdi-example/api/redis/{key}`]
- `curl -X GET http://localhost:8080/redis-cdi-example/api/redis/keys/{keyName}`]

- `curl -X POST -H "Content-Type: application/json" http://localhost:8080/redis-cdi-example/api/v1/bundles/{osName}/{1.2.3} -d '{"name": "teste", "version": "1.2", "location": "/url/test"}'`
- `curl -X GET http://localhost:8080/redis-cdi-example/api/v1/bundles/{os}/{1.2.3}`
- `docker-compose down`

## Configuration
- Use IntelliJ with smart tomcat plugin
- Java version 11

## Load tests 
- `wrk -t12 -c400 -d30s http://localhost:8080/redis-cdi-example/api/redis/key`

## Server 
- [Apache TomEE Plus 8.0.6](https://www.apache.org/dyn/closer.cgi/tomee/tomee-8.0.6/apache-tomee-8.0.6-plus.tar.gz)