plugins {
	java
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependency.management)
}

group = "com.danila.dolgov.auction"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.spring.boot.starter.data.r2dbc)
	implementation(libs.spring.boot.starter.liquibase)
	implementation(libs.spring.boot.starter.webflux)
	implementation(libs.spring.jdbc)
	implementation(libs.mapstruct.lib)
	compileOnly(libs.lombok)
	developmentOnly(libs.spring.boot.devtools)
	runtimeOnly(libs.postgresql)
	runtimeOnly(libs.r2dbc.postgresql)
	annotationProcessor(libs.lombok)
	annotationProcessor(libs.mapstruct.processor)
	annotationProcessor(libs.lombok.mapstruct.binding)
	testImplementation(libs.spring.boot.starter.data.r2dbc.test)
	testImplementation(libs.spring.boot.starter.liquibase.test)
	testImplementation(libs.spring.boot.starter.webflux.test)
	testCompileOnly(libs.lombok)
	testRuntimeOnly(libs.junit.platform.launcher)
	testAnnotationProcessor(libs.lombok)
}

tasks.withType<Test> {
	useJUnitPlatform()
}
