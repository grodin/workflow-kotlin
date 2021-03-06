plugins {
  `java-library`
  kotlin("jvm")
  id("com.vanniktech.maven.publish")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

apply(from = rootProject.file(".buildscript/configure-maven-publish.gradle"))

dependencies {
  compileOnly(Dependencies.Annotations.intellij)

  api(project(":trace-encoder"))
  api(project(":workflow-runtime"))
  api(Dependencies.Kotlin.Stdlib.jdk6)
  api(Dependencies.Kotlin.Coroutines.core)

  implementation(Dependencies.Kotlin.reflect)
  implementation(Dependencies.Kotlin.moshi)
  implementation(Dependencies.okio)
  implementation(Dependencies.moshi)

  testImplementation(Dependencies.Kotlin.Test.jdk)
  testImplementation(Dependencies.Kotlin.Test.mockito)
}
