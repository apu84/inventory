package com.example.inventory

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.http.HttpStatus
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import java.util.*

class ProductInventoryControllerTest(
    @Autowired private val restTemplate: TestRestTemplate,
) : AbstractIntegrationTest() {

    @Test
    fun `should create a new product inventory`() {
        val newProductInventory = NewProductInventory(
            productId = UUID.randomUUID(),
            stockCount = 5
        )
        println("create new inventory: $newProductInventory")
        val response = restTemplate.postForEntity(baseUrl, newProductInventory, ProductInventory::class.java)
        println("response: ${response.body}")

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(newProductInventory.productId, response.body?.productId)
        assertEquals(newProductInventory.stockCount, response.body?.stockCount)
    }

    @Test
    fun `should get an inventory by id`() {
        val newProductInventory = NewProductInventory(
            productId = UUID.randomUUID(),
            stockCount = 5
        )

        val postResponse = restTemplate.postForEntity(baseUrl, newProductInventory, ProductInventory::class.java)
        assertEquals(HttpStatus.OK, postResponse.statusCode)
        val productInventoryId = postResponse.body?.id ?: throw IllegalStateException("Inventory ID is null")

        val response = restTemplate.getForEntity("$baseUrl/$productInventoryId", ProductInventory::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(productInventoryId, response.body?.id)
        assertEquals(newProductInventory.productId, response.body?.productId)
        assertEquals(newProductInventory.stockCount, response.body?.stockCount)
    }

    companion object {
        @JvmStatic
        @Container
        @ServiceConnection
        val postgresContainer = PostgreSQLContainer<Nothing>("postgres:16.0")
    }
}