package com.sunny.ddangnmarket.appserver.web.dto.devices

import com.sunny.ddangnmarket.appserver.domain.devices.Device

class DevicesSaveRequestDto(deviceToken: String) {
    var deviceToken: String = deviceToken

    fun toEntity():Device {
        return Device(deviceToken)
    }
}