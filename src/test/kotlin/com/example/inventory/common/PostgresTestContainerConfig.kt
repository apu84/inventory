package com.example.inventory.common

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Testcontainers

//@TestConfiguration
//@Testcontainers
//class PostgresTestContainerConfig {
//    companion object {
//        private val container = PostgreSQLContainer("postgres:16.0")
//            .withDatabaseName("test")
//            .withUsername("test")
//            .withPassword("test")
//
//        init {
//            container.start()
//        }
//
//        @JvmStatic
//        @DynamicPropertySource
//        fun overrideProperties(registry: DynamicPropertyRegistry) {
//            registry.add("spring.datasource.url", container::getJdbcUrl)
//            registry.add("spring.datasource.username", container::getUsername)
//            registry.add("spring.datasource.password", container::getPassword)
//        }
//    }
//}