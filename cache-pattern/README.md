# cache-pattern


## env 

- wsl2 (Ubuntu)
- openjdk 17
- Quarkus 3.4.3
- Drools 8.44.0.Final
- Redis 7.2.2 (Docker Image)

## Running in dev mode

Before run this application, you need to setup a redis db by bellow commands.

```
docker pull redis:7.2.2
docker run --name redis_quarkus_test -p 6379:6379 redis:7.2.2
```

You can run your application in dev mode that enables live coding using:
```
./gradlew quarkusDev
```

You can call APIs from:

http://localhost:8080/q/swagger-ui


## Running in Docker Containers

As the before section, make sure the `redis:7.2.2` image is pulled. 
You can build the quarkus application docker image by:
```
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/cache-pattern-jvm .
```

Start services(the quarkus application and redis) by this docker-compose commands:
```
docker-compose -f src/main/docker/docker-compose.yml up
```

Commands to call APIs:
```
- register a product
curl -X POST -H "Content-Type: application/json" -d '{"productId":"1","name":"guitar","price":200000}' http://localhost:8080/products 

- show products
curl http://localhost:8080/products

- order
curl -X POST -H "Content-Type: application/json" -d '{"productId":"1","orderQuantity":1}' http://localhost:8080/order
```

## reference

https://ja.quarkus.io/guides/redis

https://ja.quarkus.io/guides/openapi-swaggerui

