package com.sunny.ddangnmarket.appserver.web.dto.devices

import com.sunny.ddangnmarket.appserver.domain.devices.DeviceNotificationSetting
import com.sunny.ddangnmarket.appserver.domain.notifications.NotificationType

class DeviceNotificationSettingsSaveRequestDto(deviceToken: String, type: String) {
    var deviceToken: String = deviceToken
    var type: String = type

    fun toEntity():DeviceNotificationSetting {
        return DeviceNotificationSetting(deviceToken, NotificationType.valueOf(type))
    }
}