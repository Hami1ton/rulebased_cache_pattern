# cache-pattern


Before run this application, you need to setup a redis db with bellow commands.

```
docker pull redis:7.2.2
docker run --name redis_quarkus_test -p 6379:6379 redis:7.2.2
```

## env 

- wsl2 (Ubuntu)
- openjdk 17
- Quarkus 3.4.3
- Drools 8.44.0.Final
- Redis 7.2.2 (Docker Image)

## Running in dev mode

You can run your application in dev mode that enables live coding using:
```
./gradlew quarkusDev
```

You can call APIs from:

http://localhost:8080/q/swagger-ui


## reference

https://ja.quarkus.io/guides/redis

https://ja.quarkus.io/guides/openapi-swaggerui

