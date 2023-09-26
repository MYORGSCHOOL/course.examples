# liquibase
* Для запуска модуля установить postgresql
* Прописать в [build.gradle.kts](build.gradle.kts) путь до базы

```kotlin
extra.apply {
        set("db_url", "jdbc:postgresql://localhost:5432/postgres")
        set("db_user", "postgres")
        set("db_pass", "postgres")
        }
```

Из корня проекта cource.examples выполнить для наката патчей

```
./gradlew liquibase:update
```

Также можно это сделать из панели gradle в идее
