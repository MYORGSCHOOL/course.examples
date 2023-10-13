plugins {
    id("java")
    id("org.springframework.boot") version "2.4.4" //совместима с java15
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.0")
    implementation("org.postgresql:postgresql:42.6.0")
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
    // https://mvnrepository.com/artifact/org.glassfish.jaxb/jaxb-runtime
    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.3")
    // https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api
    implementation("javax.xml.bind:jaxb-api:2.3.1")


}

tasks.test {
    useJUnitPlatform()
}
