# rulebased_cache_pattern

Quarkus × Drools × Redis

## env 

- wsl 
- openjdk 17
- Quarkus 3.4.3
- Drools 8.44.0.Final
- Redis 7.2.2

## command

- docker images
```
docker pull redis:7.2.2
docker run --name redis_quarkus_test -p 6379:6379 redis:7.2.2
```

- url
http://localhost:8080/q/swagger-ui


## reference

https://ja.quarkus.io/guides/redis

https://ja.quarkus.io/guides/openapi-swaggerui
