plugins {
    id("java")
}

group = "in.gore"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

var protocVer = "3.21.12"
var grpcVer = "1.59.1"

dependencies {

    implementation(project(":proto-lib"))
    implementation("io.grpc:grpc-stub:${grpcVer}")
    implementation("io.grpc:grpc-protobuf:${grpcVer}")
    implementation("javax.annotation:javax.annotation-api:1.3.2") // generated code uses annotations
    implementation("io.grpc:grpc-netty:${grpcVer}")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}