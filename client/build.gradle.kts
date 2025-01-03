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

var slf4jVersion = "1.7.30"
var jettyVersion = "9.4.28.v20200408"
var jerseyVersion = "2.31"

dependencies {

    implementation(project(":proto-lib"))
    implementation("io.grpc:grpc-stub:${grpcVer}")
    implementation("io.grpc:grpc-protobuf:${grpcVer}")
    implementation("javax.annotation:javax.annotation-api:1.3.2") // generated code uses annotations
    implementation("io.grpc:grpc-netty:${grpcVer}")

    // https://mvnrepository.com/artifact/net.sf.uadetector/uadetector-parent
    implementation("net.sf.uadetector:uadetector-resources:2014.10")

    // jetty start
    implementation("org.slf4j:slf4j-api:${slf4jVersion}")
    implementation("org.slf4j:slf4j-simple:${slf4jVersion}")

    implementation("org.eclipse.jetty:jetty-server:${jettyVersion}")
    implementation("org.eclipse.jetty:jetty-servlet:${jettyVersion}")

    implementation("org.glassfish.jersey.core:jersey-server:${jerseyVersion}")
    implementation("org.glassfish.jersey.containers:jersey-container-servlet-core:${jerseyVersion}")
    implementation("org.glassfish.jersey.containers:jersey-container-jetty-http:${jerseyVersion}")
    implementation("org.glassfish.jersey.media:jersey-media-json-jackson:${jerseyVersion}")
    implementation("org.glassfish.jersey.inject:jersey-hk2:${jerseyVersion}")
    // jetty end

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}