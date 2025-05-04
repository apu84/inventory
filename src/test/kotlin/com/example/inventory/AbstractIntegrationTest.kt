package com.example.inventory

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
abstract class AbstractIntegrationTest {
    @LocalServerPort
    protected var port: Int = 0

    protected val baseUrl: String
        get() = "http://localhost:$port/inventory"
}