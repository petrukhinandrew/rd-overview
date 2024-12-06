import com.jetbrains.rd.generator.gradle.RdGenExtension
import com.jetbrains.rd.generator.gradle.RdGenTask

plugins {
    kotlin("jvm") version "2.0.20"
    application
    id ("com.jetbrains.rdgen") version "2023.2.0"

}

group = "org.jacodb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.jetbrains.rd:rd-framework:2023.2.0")
    implementation("com.jetbrains.rd:rd-core:2023.2.0")
    implementation("com.jetbrains.rd:rd-gen:2023.2.0")

}

tasks.test {
    useJUnitPlatform()
}

val rdgenModelsCompileClasspath by configurations.creating {
    extendsFrom(configurations.compileClasspath.get())
}

kotlin {
    sourceSets.create("rdgenModels").apply {
        kotlin.srcDir("src/main/rdgen")
    }
    jvmToolchain(8)
}
val sourcesBaseDir = projectDir.resolve("src/main/kotlin")
val csSourcesBaseDir = projectDir.resolve("src/main/resources")
val generatedPackage = "org.example.generated"
val generatedSourceDir = sourcesBaseDir.resolve(generatedPackage.replace('.', '/'))

val generatedModelsPackage = "$generatedPackage.models"
val generatedModelsSourceDir = sourcesBaseDir.resolve(generatedModelsPackage.replace('.', '/'))
val csModelsDir = csSourcesBaseDir.resolve("cs-models")

val generateModels = tasks.register<RdGenTask>("generateProtocolModels") {
    dependsOn.addAll(listOf("compileKotlin"))
    val rdParams = extensions.getByName("params") as RdGenExtension
    val sourcesDir = projectDir.resolve("src/main/kotlin").resolve("org/example/models")

    group = "rdgen"
    rdParams.verbose = true
    rdParams.sources(sourcesDir)
    rdParams.hashFolder = layout.buildDirectory.file("rdgen/hashes").get().asFile.absolutePath
    // where to search roots
    rdParams.packages = "org.example.models"

    rdParams.generator {
        language = "kotlin"
        transform = "symmetric"
        root = "org.example.models.DemoRoot"

        directory = generatedModelsSourceDir.absolutePath
        namespace = generatedModelsPackage
    }

    rdParams.generator {
        language = "csharp"
        transform = "asis"
        root = "org.example.models.DemoRoot"

        directory = csModelsDir.absolutePath
        namespace = generatedModelsPackage
    }
}