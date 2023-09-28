plugins {
    id("java")
}

group = "org.spring"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework:spring-context:5.3.30")
}

tasks.test {
    useJUnitPlatform()
}
