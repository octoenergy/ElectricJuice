pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
        jcenter()
        maven { url = uri("https://kotlin.bintray.com/kotlinx") }
    }
}
rootProject.name = "ElectricJuice"


include(":shared")
include(":androidApp")

