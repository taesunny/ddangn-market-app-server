package com.sunny.ddangnmarket.appserver.web.dto.devices

import com.sunny.ddangnmarket.appserver.domain.devices.DeviceNotificationSetting
import java.time.LocalDateTime

class DeviceNotificationSettingsListResponseDto(entity:DeviceNotificationSetting) {
    var id: Long ?= entity.id
    var deviceToken: String = entity.deviceToken
    var type: String = entity.type.text
    var createdAt: LocalDateTime ?= entity.createdAt
}