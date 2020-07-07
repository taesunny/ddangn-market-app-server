import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"

	id("org.jetbrains.kotlin.plugin.allopen") version "1.3.72"
//	id("org.jetbrains.kotlin.plugin.noarg") version "1.3.72"
	id ("org.jetbrains.kotlin.plugin.jpa") version "1.3.72"

	id ("com.bmuschko.docker-java-application") version "6.4.0"
}

allOpen {
	annotation("javax.persistence.Entity")
}

group = "com.sunny.ddangn-market"
version = "0.1.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

docker {
	javaApplication {
		baseImage.set("openjdk:8-alpine")
		maintainer.set("Taesun Lee 'superbsun@gmail.com'")
		ports.set(listOf(8088))
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
//	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("io.jsonwebtoken:jjwt:0.7.0")
//	implementation ("org.hibernate:hibernate-validator:6.1.5.Final")
	implementation("org.keycloak:keycloak-spring-boot-starter:10.0.2")
	implementation("org.keycloak.bom:keycloak-adapter-bom:10.0.2")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:2.2.3.RELEASE")

    implementation("com.google.firebase:firebase-admin:6.8.1")
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
