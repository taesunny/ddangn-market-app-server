package com.sunny.ddangnmarket.appserver.web

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
    @RequestMapping("/api/v1/available")
    fun available(): String? {
        return "It's available - product server"
    }

    @RequestMapping("/api/v1/checked-out")
    fun checkedOut(): String? {
        return "Checked out - product server"
    }
}