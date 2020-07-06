package com.sunny.ddangnmarket.appserver.service.devices

import com.sunny.ddangnmarket.appserver.domain.devices.DeviceNotificationSetting
import com.sunny.ddangnmarket.appserver.domain.devices.DeviceNotificationSettingRepository
import com.sunny.ddangnmarket.appserver.web.dto.devices.DeviceNotificationSettingsListResponseDto
import com.sunny.ddangnmarket.appserver.web.dto.devices.DeviceNotificationSettingsSaveRequestDto
import com.sunny.ddangnmarket.appserver.web.dto.devices.DevicesListResponseDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class DeviceNotificationSettingsService {
    lateinit var deviceNotificationSettingRepository: DeviceNotificationSettingRepository

    @Transactional
    fun save(requestDto: DeviceNotificationSettingsSaveRequestDto): Long? {
        return deviceNotificationSettingRepository.save(requestDto.toEntity()).id
    }

    @Transactional
    fun delete(id: Long) {
        var deviceNotiSetting: DeviceNotificationSetting  = deviceNotificationSettingRepository.findById(id)
                .orElse(throw IllegalArgumentException("No device noti setting. id=$id"))

        deviceNotificationSettingRepository.delete(deviceNotiSetting)
    }

    @Transactional(readOnly = true)
    fun findAllByDeviceToken(deviceToken: String):List<DeviceNotificationSettingsListResponseDto> {
        return deviceNotificationSettingRepository.findByDeviceToken(deviceToken).stream()
                .map { DeviceNotificationSettingsListResponseDto(it) }
                .collect(Collectors.toList<DeviceNotificationSettingsListResponseDto>())
    }
}