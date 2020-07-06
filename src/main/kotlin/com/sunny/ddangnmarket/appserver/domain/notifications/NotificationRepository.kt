package com.sunny.ddangnmarket.appserver.domain.notifications

import com.sunny.ddangnmarket.appserver.domain.devices.Device
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface NotificationRepository:JpaRepository<Notification, Long>{
    @Query("SELECT n FROM Notification n ORDER BY n.id DESC")
    fun findAllDesc(): List<Notification>
}