plugins {
    val kotlinVersion = "2.0.0-Beta3"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion apply false
    id("org.springframework.boot") version "3.2.1" apply false
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("plugin.noarg") version kotlinVersion
}

val meowVersion by extra("1.0-SNAPSHOT")
buildscript {
    extra.apply {
        set("beetlsql.version", "3.27.2-RELEASE")
        set("mysql.connector.version", "8.0.33")
        set("hutool.version", "5.8.24")
    }
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
