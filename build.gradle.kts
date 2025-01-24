import org.asciidoctor.gradle.jvm.AsciidoctorTask
import org.asciidoctor.gradle.jvm.pdf.AsciidoctorPdfTask

plugins {
    alias(libs.plugins.asciidoctor.convert)
    alias(libs.plugins.asciidoctor.pdf)
    alias(libs.plugins.asciidoctor.gems)
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
        sources("index.adoc")
        outputOptions {
            backends("spring-html")
        }
        configurations("asciidoctorExt")
    }
    named<AsciidoctorPdfTask>("asciidoctorPdf") {
        dependsOn(asciidoctorGemsPrepare)
        sourceDir(file("src/main/asciidoc"))
        sources("index.adoc")
        setFontsDirs(
            listOf(
                "src/main/resources/fonts",
            )
        )
        baseDirFollowsSourceFile()
        setTheme("bridge")
    }
}

pdfThemes {
    local("bridge") {
        themeDir = file("src/main/resources/themes")
    }
}
