# spring-boot
* Для запуска модуля установить postgresql
* Прописать в [Application.properties](src/main/resources/application.properties) пути до БД
```
  spring.datasource.driver-class-name=org.postgresql.Driver
  spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
  spring.datasource.username=postgres
  spring.datasource.password=postgres
```
*  Запустить main метод
* Запустить запрос из [requests.http](docs/requests.http)
либо
```
curl localhost:8080/
```
