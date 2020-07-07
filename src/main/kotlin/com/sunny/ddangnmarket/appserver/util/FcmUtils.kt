package com.sunny.ddangnmarket.appserver.util

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.springframework.core.io.ClassPathResource

class FcmUtils {
    companion object {
        fun getAccessToken(): String {
            var firebaseConfig: String = "firebase/ddangn-market-firebase-adminsdk-3mzu4-40dbafccba.json"

            var googleCredential: GoogleCredentials = GoogleCredentials.fromStream(ClassPathResource(firebaseConfig).inputStream)
                    .createScoped(listOf("https://www.googleapis.com/auth/cloud-platform"))

            googleCredential.refreshIfExpired()
            return googleCredential.accessToken.tokenValue
        }

        fun sendMessage(type: String, title: String, message: String) {
            val notification: Notification = Notification("($type) $title", message)

            val message = Message.builder()
//                    .setToken(deviceToken)
                    .setNotification(notification)
                    .setTopic("all")
                    .putData("type", type)
                    .build()

            val response = FirebaseMessaging.getInstance().send(message)

            println("FCM send response : $response")
        }
    }
}