
dependencies {
    api(project(":domain"))
    api("com.ibeetl:sql-springboot-starter:${rootProject.extra["beetlsql.version"]}")
    runtimeOnly("mysql:mysql-connector-java:${rootProject.extra["mysql.connector.version"]}")
    api("com.ibeetl:sql-accelerator:${rootProject.extra["beetlsql.version"]}")
}
