apply {
    from("$rootDir/android-library-build.gradle")
}


// the ones independent to this module
dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.components))
    "implementation"(project(Modules.heroDomain))
    "implementation"(project(Modules.heroInteractors))

    "implementation"(SqlDelight.androidDriver)

    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)

    "implementation"(Coil.coil)

    // testing part
    "androidTestImplementation"(project(Modules.heroDataSourceTest))
    "androidTestImplementation"(ComposeTest.uiTestJunit4)
    "debugImplementation"(ComposeTest.uiTestManifest)
    "androidTestImplementation"(Junit.junit4)
}