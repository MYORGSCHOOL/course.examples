plugins {
    id("java")
    id("war")
}

group = "org.servlet"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("javax.servlet.jsp:jsp-api:2.2")
}

tasks.test {
    useJUnitPlatform()
}
