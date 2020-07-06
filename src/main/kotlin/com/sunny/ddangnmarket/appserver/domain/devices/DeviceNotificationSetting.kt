package com.sunny.ddangnmarket.appserver.domain.devices

import com.sunny.ddangnmarket.appserver.domain.notifications.NotificationType
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class DeviceNotificationSetting(deviceToken: String, type: NotificationType) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null

        @Column(nullable = false)
        var deviceToken: String = deviceToken

        @Column(nullable = false)
        var type: NotificationType = type

        @CreatedDate
        val createdAt: LocalDateTime? = null
}