
dependencies {
    api(project(":domain"))
    api("com.ibeetl:sql-springboot-starter:3.27.2-RELEASE")
    runtimeOnly("mysql:mysql-connector-java:8.0.33")
    api("com.ibeetl:sql-accelerator:3.27.2-RELEASE")
}
