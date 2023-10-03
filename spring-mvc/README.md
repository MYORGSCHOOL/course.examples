# spring-mvc
Для запуска модуля установить postgresql

Прописать в [build.gradle.kts](build.gradle.kts) путь до базы

```kotlin
extra.apply {
        set("db_url", "jdbc:postgresql://localhost:5432/postgres")
        set("db_user", "postgres")
        set("db_pass", "postgres")
        }
```

Из корня проекта cource.examples выполнить для наката патчей

```
./gradlew spring-mvc:update
```

Также можно это сделать из панели gradle в идее на соответствующем модуле

Прописать коннекты к базе в файле [dispatcher-servlet.xml](src/main/webapp/WEB-INF/dispatcher-servlet.xml)

Установить tomcat версии 8 (8.5.93 например)

Сформировать артефакт war и задеплоить его
