package com.sunny.ddangnmarket.appserver.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream

@Configuration
class FcmConfig {
    @Bean
    fun appServerFirebase():FirebaseApp {
//        val serviceAccount = FileInputStream("src/main/resources/firebase/ddangn-market-firebase-adminsdk-3mzu4-40dbafccba.json")

        val serviceAccount = FcmConfig::class.java.getResourceAsStream("/ddangn-market-firebase-adminsdk-3mzu4-ce51961862.json")

        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://ddangn-market.firebaseio.com")
                .build()

        return FirebaseApp.initializeApp(options)
    }
}