apply {
    from("$rootDir/library-build.gradle")
}

// the ones independent to this module
dependencies {
    "implementation"(project(Modules.core))
}