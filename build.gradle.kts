import org.asciidoctor.gradle.jvm.AsciidoctorTask

plugins {
    id("org.asciidoctor.jvm.convert") version "3.3.2"
}

repositories {
    mavenCentral()
}

tasks {
    "asciidoctor"(AsciidoctorTask::class) {
        sourceDir("src/docs/asciidoc")
        baseDirIsRootProjectDir()
        //outputs.dir("build/docs")
        //sourceDir = file("docs")
    }
}

