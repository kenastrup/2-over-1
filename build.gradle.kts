import org.asciidoctor.gradle.jvm.AsciidoctorTask
import org.asciidoctor.gradle.jvm.pdf.AsciidoctorPdfTask

plugins {
    id("org.asciidoctor.jvm.convert") version "4.0.3"
    id("org.asciidoctor.jvm.pdf") version "4.0.3"
    id("org.asciidoctor.jvm.gems") version "4.0.3"
}

repositories {
    mavenCentral()
    ruby.gems()
}
val asciidoctorExt: Configuration by configurations.creating

dependencies {
    asciidoctorExt("io.spring.asciidoctor.backends:spring-asciidoctor-backends:0.0.7")
    asciidoctorGems("rubygems:rouge:3.15.0")
}

tasks {
    named<AsciidoctorTask>("asciidoctor") {
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
    named<AsciidoctorPdfTask>("asciidoctorPdf") {
        dependsOn(asciidoctorGemsPrepare)
        sourceDir(file("src/main/asciidoc"))
        sources("2-over-1.adoc")
        setFontsDirs(
            listOf(
                "src/main/resources/fonts",
            )
        )
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
