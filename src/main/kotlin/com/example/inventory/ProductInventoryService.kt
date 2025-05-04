package com.example.inventory

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class ProductInventoryService(private val repository: ProductRepository) {
    @Transactional
    fun createProductInventory(newProductInventory: NewProductInventory): ProductInventory {
        val inventory = Inventory(
            null,
            productId = newProductInventory.productId,
            stockCount = newProductInventory.stockCount,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
        val savedProductInventory = repository.save(inventory)
        return toProductInventory(savedProductInventory)
    }

    fun getProductInventory(id: UUID): ProductInventory {
        val productInventoryEntity = repository.findById(id).orElseThrow {
            NoSuchElementException("Inventory not found with id: $id")
        }
        return toProductInventory(productInventoryEntity)
    }

    fun toProductInventory(inventory: Inventory): ProductInventory {
        return ProductInventory(
            id = inventory.id!!,
            productId = inventory.productId,
            stockCount = inventory.stockCount,
            createdAt = inventory.createdAt,
            updatedAt = inventory.updatedAt
        )
    }
}