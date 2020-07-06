package com.sunny.ddangnmarket.appserver.domain.devices

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DeviceNotificationSettingRepository:JpaRepository<DeviceNotificationSetting, Long>{
    fun findByDeviceToken(deviceToken: String): List<DeviceNotificationSetting>
}