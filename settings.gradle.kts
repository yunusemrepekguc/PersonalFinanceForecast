pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PersonalFinanceForecast"
include(":app")

include(":core:core-common")
include(":core:core-network")
include(":core:core-database")
include(":core:core-domain")
include(":core:core-di")

include(":feature:feature-account")
include(":feature:feature-category")
