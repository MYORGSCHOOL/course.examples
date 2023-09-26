# hibernate-locking
* Для запуска модуля установить postgresql
* Прописать в [persistence.xml](src/main/resources/META-INF/persistence.xml) путь до базы

```xml
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
             version="2.1">
    <persistence-unit name="org.java.courses_h2">

        <class>org.locking.entity.Student</class>
        <class>org.locking.entity.StudentWithVersion</class>
        <properties>
            <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>

            <!-- Database Connection Settings -->
            <property name="hibernate.connection.driver_class" value="org.postgresql.Driver"/>
            <property name="hibernate.connection.url" value="jdbc:postgresql://localhost:5432/postgres"/>
            <property name="hibernate.connection.username" value="postgres"/>
            <property name="hibernate.connection.password" value="postgres"/>
            <property name="hibernate.hbm2ddl.auto" value="create-drop"/>
            <property name="hibernate.show_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>


```

