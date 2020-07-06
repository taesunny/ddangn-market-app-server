package com.sunny.ddangnmarket.appserver.web.dto.devices

import com.sunny.ddangnmarket.appserver.domain.devices.Device
import java.time.LocalDateTime

class DevicesListResponseDto(entity:Device) {
    var id: Long ?= entity.id
    var deviceToken: String = entity.deviceToken
    var createdAt: LocalDateTime ?= entity.createdAt
}