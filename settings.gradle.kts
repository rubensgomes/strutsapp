rootProject.name = "strutsapp"
include("app")

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()

        // Apache nexus staging repository (used by Struts 2)
        maven(url = uri("https://repository.apache.org/content/groups/staging/"))

        // Rubens personal maven repository
        maven {
            url = uri("https://repo.repsy.io/mvn/rubensgomes/default/")
        }
    }

    versionCatalogs {
        create("libs") {
            from("com.rubensgomes:catalog:0.0.26")
        }
    }
}
