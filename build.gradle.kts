import org.asciidoctor.gradle.jvm.AsciidoctorTask
import org.asciidoctor.gradle.jvm.pdf.AsciidoctorPdfTask

plugins {
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    id("org.asciidoctor.jvm.pdf") version "3.3.2"
}

repositories {
    mavenCentral()
}
val asciidoctorExt: Configuration by configurations.creating

dependencies {
    asciidoctorExt("io.spring.asciidoctor.backends:spring-asciidoctor-backends:0.0.7")
}

tasks {
    "asciidoctor"(AsciidoctorTask::class) {
        sourceDir(file("src/main/asciidoc"))
        resources {
            from("src/main/resources/")
            include("css/**")
        }
        baseDirFollowsSourceFile()
        sources("2-over-1.adoc")
        outputOptions {
            backends("spring-html")
        }
        configurations("asciidoctorExt")
    }
    "asciidoctorPdf"(AsciidoctorPdfTask::class) {
        sourceDir(file("src/docs/asciidoc"))
        setFontsDirs(listOf("src/main/resources/fonts"))
        baseDirFollowsSourceFile()
        setTheme("bridge")
        sources("2-over-1.adoc")
    }
}

pdfThemes {
    local("bridge") {
        themeDir = file("src/main/resources/themes")
    }
}
