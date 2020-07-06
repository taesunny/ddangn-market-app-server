package com.sunny.ddangnmarket.appserver.domain.notifications

import java.util.*
import java.util.concurrent.ConcurrentHashMap

enum class NotificationType(val text: String) {
    NOTICE("공지"),
    ADVERTISEMENT("광고");

}
