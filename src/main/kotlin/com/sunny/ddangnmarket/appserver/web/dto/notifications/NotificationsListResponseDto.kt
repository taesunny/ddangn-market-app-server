package com.sunny.ddangnmarket.appserver.web.dto.notifications

import com.sunny.ddangnmarket.appserver.domain.notifications.Notification
import java.time.LocalDateTime

class NotificationsListResponseDto(entity:Notification) {
    var id: Long ?= entity.id
    var type: String = entity.type.text
    var title: String = entity.title
    var message: String = entity.message
    var creatorId: String = entity.creatorId
    var createdAt: LocalDateTime ?= entity.createdAt
}