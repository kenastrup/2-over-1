import org.asciidoctor.gradle.jvm.AsciidoctorTask
import org.asciidoctor.gradle.jvm.pdf.AsciidoctorPdfTask

plugins {
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    id("org.asciidoctor.jvm.pdf") version "3.3.2"
}

repositories {
    mavenCentral()
}

tasks {
    "asciidoctor"(AsciidoctorTask::class) {
        sourceDir(file("src/docs/asciidoc"))
        baseDirFollowsSourceFile()
    }
    "asciidoctorPdf"(AsciidoctorPdfTask::class) {
        sourceDir(file("src/docs/asciidoc"))
        baseDirFollowsSourceFile()
        setTheme("bridge")
        sources("2-over-1.adoc")
    }
}

pdfThemes {
    local("bridge" ) {
        themeDir = file("src/docs/theme")
    }
}
