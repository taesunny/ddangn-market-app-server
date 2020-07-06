package com.sunny.ddangnmarket.appserver.service.notification

import com.sunny.ddangnmarket.appserver.domain.devices.Device
import com.sunny.ddangnmarket.appserver.domain.devices.DeviceRepository
import com.sunny.ddangnmarket.appserver.domain.notifications.Notification
import com.sunny.ddangnmarket.appserver.domain.notifications.NotificationRepository
import com.sunny.ddangnmarket.appserver.web.dto.devices.DevicesListResponseDto
import com.sunny.ddangnmarket.appserver.web.dto.devices.DevicesSaveRequestDto
import com.sunny.ddangnmarket.appserver.web.dto.notifications.NotificationSaveRequestDto
import com.sunny.ddangnmarket.appserver.web.dto.notifications.NotificationsListResponseDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class NotificationsService {
    lateinit var notiRepository: NotificationRepository

    @Transactional
    fun save(requestDto: NotificationSaveRequestDto, creatorId: String): Long? {
        return notiRepository.save(requestDto.toEntity(creatorId)).id
    }

    @Transactional
    fun delete(id: Long) {
        var noti: Notification  = notiRepository.findById(id)
                .orElse(throw IllegalArgumentException("No noti. id=$id"))

        notiRepository.delete(noti)
    }

    @Transactional(readOnly = true)
    fun findAllDesc():List<NotificationsListResponseDto> {
        return notiRepository.findAllDesc().stream()
                .map { NotificationsListResponseDto(it) }
                .collect(Collectors.toList<NotificationsListResponseDto>())
    }
}