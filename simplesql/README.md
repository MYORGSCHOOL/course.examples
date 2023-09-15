# simplesql
* Для запуска модуля установить postgresql
* Прогнать скрипт

```sql
create table users (
    id serial,
    name varchar (20),
    surname varchar (20)
    );

insert into users(name, surname) values ('Irina', 'Kuzmina')

```
* Прописать креды для доступа к базе в классе [DatabaseConnection.java](src/main/java/org/example/dao/DatabaseConnection.java)
