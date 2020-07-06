package com.sunny.ddangnmarket.appserver.util

import org.keycloak.KeycloakPrincipal
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken
import javax.servlet.http.HttpServletRequest

class KeyCloakUtils {
    companion object {
        fun getUserId(request: HttpServletRequest): String {
            val token = request.userPrincipal as KeycloakAuthenticationToken
            val principal = token.principal as KeycloakPrincipal<*>
            val session = principal.keycloakSecurityContext
            val accessToken = session.token

            return accessToken.subject
        }
    }
}