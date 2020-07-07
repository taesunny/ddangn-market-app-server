package com.sunny.ddangnmarket.appserver

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.sunny.ddangnmarket.appserver.util.FcmUtils
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.FileInputStream


@SpringBootApplication
class AppServerApplication

fun main(args: Array<String>) {
	runApplication<AppServerApplication>(*args)
}
