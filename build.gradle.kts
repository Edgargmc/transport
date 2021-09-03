import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "kata.mastermind"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("reflect"))
        testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
        testImplementation("org.assertj:assertj-core:3.19.0")
        testImplementation("io.mockk:mockk:1.12.0")
        testImplementation("net.bytebuddy:byte-buddy:1.11.1")
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<Test>().configureEach {
        reports.html.isEnabled = false
        reports.junitXml.isEnabled = false
    }

    tasks.withType<KotlinCompile>() {
        kotlinOptions.jvmTarget = "16"
    }

    kotlin {
        sourceSets["main"].apply { kotlin.srcDirs("src") }
        sourceSets["test"].apply { kotlin.srcDir("test") }
    }

    java {
        sourceSets["main"].apply { java.srcDirs("src") }
        sourceSets["test"].apply { java.srcDir("test") }
    }
}

