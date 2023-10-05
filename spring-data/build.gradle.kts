plugins {
    id("java")
    id("war")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    //пришлось понизить, так как необходимо в спринт добавить адаптер хибера а спринг
    // в 15 жаве не работает с jakarta зависимостями

    //https://habr.com/ru/companies/naumen/articles/708244/
    implementation("org.hibernate:hibernate-core:5.6.15.Final")

    implementation("org.postgresql:postgresql:42.6.0")
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
    implementation("ma.glasnost.orika:orika-core:1.5.4")
    implementation("jstl:jstl:1.2")
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
    implementation("org.springframework.data:spring-data-jpa:2.7.8")
    implementation("org.springframework:spring-webmvc:5.3.15")
    implementation("javax.servlet:javax.servlet-api:4.0.1")
}

tasks.test {
    useJUnitPlatform()
}
