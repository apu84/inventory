package com.example.inventory

import org.junit.jupiter.api.Test
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container

class InventoryApplicationTests : AbstractIntegrationTest() {

    @Test
    fun contextLoads() {
        println("Context loads successfully")
    }

    companion object {
        @JvmStatic
        @Container
        @ServiceConnection
        val postgresContainer = PostgreSQLContainer<Nothing>("postgres:16.0")
    }
}
