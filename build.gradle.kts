plugins {
    java
}

dependencies {
    compileOnly(files("lib/spoutpluginapi.jar"))
    compileOnly(files("lib/craftbukkit.jar"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}
