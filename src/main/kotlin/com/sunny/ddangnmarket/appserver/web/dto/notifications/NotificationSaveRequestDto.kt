package com.sunny.ddangnmarket.appserver.web.dto.notifications

//import com.sunny.ddangnmarket.appserver.domain.notifications.Notification
//import com.sunny.ddangnmarket.appserver.domain.notifications.NotificationType

class NotificationSaveRequestDto(type: String, title: String, message: String) {
    var type: String = type
    var title: String = title
    var message: String = message

//    fun toEntity(creatorId: String):Notification {
//        return Notification(NotificationType.valueOf(type), title, message, creatorId)
//    }
}