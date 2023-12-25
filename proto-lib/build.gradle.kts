import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.ofSourceSet
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc
import com.google.protobuf.gradle.plugins

plugins {
    id("java-library")
    id("com.google.protobuf") version "0.8.19"
}

group = "in.gore"

repositories {
    mavenCentral()
}

var protocVer = "3.21.12"
var grpcVer = "1.59.1"



sourceSets {
    main {
        java {
            srcDirs("build/generated/source/proto/main/java", "build/generated/source/proto/main/grpc")
        }
    }
}

dependencies {
    api("io.grpc:grpc-stub:${grpcVer}")
    api("io.grpc:grpc-protobuf:${grpcVer}")
    api("javax.annotation:javax.annotation-api:1.3.2") // generated code uses annotations


    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${protocVer}"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVer}"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach { task ->
            task.plugins {
                id("grpc")
            }
        }
    }
}