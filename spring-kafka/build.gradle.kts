plugins {
    id("java")
    id("org.springframework.boot") version "2.7.16" //совместима с java15
}

group = "org.kafka"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    //для kafka template

    implementation("org.springframework.kafka:spring-kafka:2.9.12")

    implementation("org.springframework.boot:spring-boot-starter:2.7.16")
}

tasks.test {
    useJUnitPlatform()
}

