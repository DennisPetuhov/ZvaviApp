rootProject.name = "ZvaviApp"

pluginManagement {
    includeBuild("build-logic/base")
    repositories {
        google {
            content {
              	includeGroupByRegex("com\\.android.*")
              	includeGroupByRegex("com\\.google.*")
              	includeGroupByRegex("androidx.*")
              	includeGroupByRegex("android.*")
            }
        }
        gradlePluginPortal()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        google {
            content {
              	includeGroupByRegex("com\\.android.*")
              	includeGroupByRegex("com\\.google.*")
              	includeGroupByRegex("androidx.*")
              	includeGroupByRegex("android.*")
            }
        }
        mavenCentral()
    }
}
include(":composeApp")
include(":common:feature:bulletin:presentation")
include(":common:core:foundation")
include(":common:core:designsystem")
include(":common:core:network")
include(":common:core:database")
include(":common:feature:bulletin:api")
include(":common:feature:bulletin:data")