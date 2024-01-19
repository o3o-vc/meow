plugins {
    id("org.springframework.boot")
    kotlin("plugin.spring")
}



configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
dependencies {
    api(project(":service"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}








