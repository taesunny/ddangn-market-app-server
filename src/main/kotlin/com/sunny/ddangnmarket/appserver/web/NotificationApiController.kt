package com.sunny.ddangnmarket.appserver.web

//import com.sunny.ddangnmarket.appserver.service.notification.NotificationsService
import com.sunny.ddangnmarket.appserver.util.FcmUtils
import com.sunny.ddangnmarket.appserver.util.KeyCloakUtils
import com.sunny.ddangnmarket.appserver.web.dto.notifications.NotificationSaveRequestDto
import org.keycloak.KeycloakPrincipal
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/v1")
class NotificationApiController {

//    lateinit var notiService:NotificationsService

    @PostMapping("/notifications")
    fun save(@RequestBody requestDto:NotificationSaveRequestDto, request: HttpServletRequest) {
        // notiService.save(requestDto, KeyCloakUtils.getUserId(request))

        println("notificationsCreate service called!!!")
        FcmUtils.sendMessage(requestDto.type, requestDto.title, requestDto.message)
    }

    @GetMapping("/notifications")
    fun get(request: HttpServletRequest): String {
        val token = request.userPrincipal as KeycloakAuthenticationToken
        val principal = token.principal as KeycloakPrincipal<*>
        val session = principal.keycloakSecurityContext
        val accessToken = session.token

        println(accessToken.profile)
        println(accessToken.scope)
        println(accessToken.realmAccess)
        println(accessToken.authorization)
        return "noti-get test"
    }
}