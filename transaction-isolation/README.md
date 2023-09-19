# transaction-isolation

Для запуска модуля устанавливаем docker https://www.docker.com/get-started/
 
В модуле присутствует файл [docker-compose.yaml](docker-compose.yaml), который можно запустить/остановить прям из идеи

Если идея запускать не хочет, то в директории модуля для запуска образа выполнить  
```
docker compose up
```
Для остановки
```
docker compose stop
```

После запуска образа у вас будет доступна база данных mysql

```
jdbc:mysql://localhost:3306
```

```
Логин: root
Пароль: secret
```

Для проверки работы уровней изоляции транзакций в классе [Main](src/main/java/org/sber/Main.java)
снимать комментарий на соответствующих методах и менять уровень изоляций в [hibernate.cfg.xml](src/main/resources/hibernate.cfg.xml)
