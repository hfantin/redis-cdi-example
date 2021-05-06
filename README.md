# Example of cdi project with redis

## Test

- `docker-compose up -d`
- `curl -X POST http://localhost:8080/redis-cdi-example/api/redis/key -d value`
- `curl -X GET http://localhost:8080/redis-cdi-example/api/redis/key`]

- `curl -X POST -H "Content-Type: application/json" http://localhost:8080/redis-cdi-example/api/v1/bundles/os/1.2.3 -d '{"name": "teste", "version": "1.2", "location": "/url/test"}'`
- `curl -X GET http://localhost:8080/redis-cdi-example/api/v1/bundles/os/1.2.3`
- `docker-compose down`

## load
- `wrk -t12 -c400 -d30s http://localhost:8080/redis-cdi-example/api/redis/key`