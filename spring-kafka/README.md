# spring-kafka

Для запуска модуля устанавливаем docker https://www.docker.com/get-started/
 
В модуле присутствует файл [docker-compose.yaml](docker-compose.yml), который можно запустить/остановить прям из идеи

Если идея запускать не хочет, то в директории модуля для запуска образа выполнить  
```
docker compose up
```
Для остановки
```
docker compose stop
```

После запуска образа у вас будет доступна кафка по адресу

```
localhost:29092
```

Для проверки работы отправки и получения сообщений из кафки запустить метод main [Main](src/main/java/org/kafka/Main.java)
