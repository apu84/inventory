package com.example.inventory

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/inventory")
class ProductInventoryController(private val productInventoryService: ProductInventoryService) {
    private val logger: Logger = LoggerFactory.getLogger(ProductInventoryController::class.java)

    @GetMapping("/{id}")
    fun getProductInventory(@PathVariable id: UUID): ProductInventory {
        logger.info("Get inventory with id: $id")
        val productInventory = productInventoryService.getProductInventory(id)
        return productInventory
    }

    @PostMapping
    fun createProductInventory(@RequestBody newProductInventory: NewProductInventory): ProductInventory {
        logger.info("Create a new product inventory {}", newProductInventory)
        val savedProductInventory = productInventoryService.createProductInventory(newProductInventory)
        logger.info("Product inventory created successfully: $savedProductInventory")
        return savedProductInventory
    }
}