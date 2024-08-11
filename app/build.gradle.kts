import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
  id("idea")
  id("version-catalog")
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.kotlin.spring)
  alias(libs.plugins.release)
  alias(libs.plugins.spotless)
  alias(libs.plugins.spring.boot)
  alias(libs.plugins.spring.dependency.management)
}

val group: String by project
val version: String by project

project.group = group

project.version = version

idea {
  module {
    isDownloadJavadoc = true
    isDownloadSources = true
  }
}

java {
  withSourcesJar()
  withJavadocJar()
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
    vendor.set(JvmVendorSpec.AMAZON)
  }
}

kotlin {
  compilerOptions {
    /**
     * Java types used by Kotlin relaxes the null-safety checks. And the Spring Framework provides
     * null-safety annotations that could be potentially used by Kotlin types. Therefore, we need to
     * make jsr305 "strict" to ensure null-safety checks is NOT relaxed in Kotlin when Java
     * annotations, which are Kotlin platform types, are used.
     */
    freeCompilerArgs.addAll("-Xjsr305=strict")
  }
}

// spotless static analyzer
configure<com.diffplug.gradle.spotless.SpotlessExtension> {
  kotlin {
    ktfmt()
    ktlint()
  }

  kotlinGradle {
    target("*.gradle.kts")
    ktfmt()
  }
}

// "net.researchgate.release" configuration
release {
  with(git) {
    pushReleaseVersionBranch.set("release")
    requireBranch.set("main")
  }
}

configurations { compileOnly { extendsFrom(configurations.annotationProcessor.get()) } }

dependencies {
  // ########## compileOnly ##################################################
  compileOnly("jakarta.servlet:jakarta.servlet-api")

  // ########## implementation ###############################################
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation(platform("org.apache.struts:struts2-bom:7.0.0-M9"))
  implementation("org.apache.struts:struts2-core")
  implementation("org.apache.struts:struts2-convention-plugin")
  implementation("org.apache.commons:commons-lang3")
  // required by Spring Boot:
  implementation(libs.kotlin.reflect)
  implementation(libs.kotlin.stdlib)
  implementation(libs.jackson.module.kotlin)

  // ########## runtimeOnly ###############################################
  runtimeOnly("jakarta.servlet.jsp:jakarta.servlet.jsp-api")
  runtimeOnly("org.apache.struts:struts2-spring-plugin")
  runtimeOnly("org.springframework.boot:spring-boot-devtools")

  // ########## testImplementation ###########################################
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.apache.struts:struts2-junit-plugin")
  testImplementation(libs.bundles.kotlin.junit5)

  // ########## testRuntimeOnly ##############################################
  testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.named<Test>("test") {
  // Use JUnit Platform for unit tests.
  useJUnitPlatform()
  // WARNING: If a serviceability tool is in use, please run with
  // -XX:+EnableDynamicAgentLoading to hide this warning
  jvmArgs("-XX:+EnableDynamicAgentLoading")
}

// Spring Boot bootRun task
tasks.named<BootRun>("bootRun") {
  // The main function declared inside the package containing the file
  // "StrutsApp.kt"kage org.example, including extension functions, are compiled into static methods
  // of a Java class named org.example.AppKt
  mainClass.set("com.rubensgomes.springstruts.StrutsAppKt")
}
