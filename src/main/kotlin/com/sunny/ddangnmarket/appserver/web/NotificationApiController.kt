package com.sunny.ddangnmarket.appserver.web

import com.sunny.ddangnmarket.appserver.service.notification.NotificationsService
import com.sunny.ddangnmarket.appserver.util.KeyCloakUtils
import com.sunny.ddangnmarket.appserver.web.dto.notifications.NotificationSaveRequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/v1/notifications")
class NotificationApiController {

    lateinit var notiService:NotificationsService

    @PostMapping()
    fun save(@RequestBody requestDto:NotificationSaveRequestDto, request: HttpServletRequest) {
        // notiService.save(requestDto, KeyCloakUtils.getUserId(request))

    }
}