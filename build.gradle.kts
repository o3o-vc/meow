plugins {
    kotlin("jvm") version kotlinVersion
    id("org.springframework.boot") version springbootVersion apply false
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("plugin.noarg") version kotlinVersion
}
buildscript {
    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
//        classpath("org.jetbrains.kotlin:kotlin-noarg:${kotlinVersion}")
    }

}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {
    group = "com.oz"
    version = meowVersion

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.plugin.noarg")
    }
    noArg {//无效
        annotation("com.oz.meow.annotation.NoArg")
        invokeInitializers = true
    }
    dependencies {

    }
    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }
}
tasks.named<Jar>("jar") {
    enabled = false
}
