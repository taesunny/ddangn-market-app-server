package com.sunny.ddangnmarket.appserver.domain.notifications

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Notification(type: NotificationType, title: String, message: String, creatorId: String) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long ?= null

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        var type: NotificationType = type

        @Column(nullable = false)
        var title: String = title

        @Column(nullable = false)
        var message: String = message

        @Column(nullable = false)
        var creatorId: String = creatorId

        @CreatedDate
        val createdAt: LocalDateTime? = null
}