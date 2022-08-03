apply {
    from("$rootDir/android-library-build.gradle")
}


// the ones independent to this module
dependencies {
    "implementation"(project(Modules.core))
}