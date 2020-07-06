package com.sunny.ddangnmarket.appserver.service.devices

import com.sunny.ddangnmarket.appserver.domain.devices.Device
import com.sunny.ddangnmarket.appserver.domain.devices.DeviceRepository
import com.sunny.ddangnmarket.appserver.web.dto.devices.DevicesListResponseDto
import com.sunny.ddangnmarket.appserver.web.dto.devices.DevicesSaveRequestDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class DevicesService {
    lateinit var deviceRepository: DeviceRepository

    @Transactional
    fun save(requestDto: DevicesSaveRequestDto): Long? {
        return deviceRepository.save(requestDto.toEntity()).id
    }

    @Transactional
    fun delete(id: Long) {
        var device: Device  = deviceRepository.findById(id)
                .orElse(throw IllegalArgumentException("No device. id=$id"))

        deviceRepository.delete(device)
    }

    @Transactional(readOnly = true)
    fun findAllDesc():List<DevicesListResponseDto> {
        return deviceRepository.findAllDesc().stream()
                .map { DevicesListResponseDto(it) }
                .collect(Collectors.toList<DevicesListResponseDto>())
    }
}