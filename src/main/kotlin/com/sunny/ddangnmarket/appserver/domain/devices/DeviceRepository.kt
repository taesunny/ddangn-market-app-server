package com.sunny.ddangnmarket.appserver.domain.devices

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DeviceRepository:JpaRepository<Device, Long> {
    @Query("SELECT d FROM Device d ORDER BY d.id DESC")
    fun findAllDesc(): List<Device>
}