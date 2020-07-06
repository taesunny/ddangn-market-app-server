package com.sunny.ddangnmarket.appserver.domain.devices

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Device(deviceToken: String) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null

        @Column(nullable = false, unique = true)
        var deviceToken: String = deviceToken

        @CreatedDate
        val createdAt: LocalDateTime? = null
}