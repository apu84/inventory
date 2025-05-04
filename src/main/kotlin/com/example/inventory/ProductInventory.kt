package com.example.inventory

import java.time.Instant
import java.util.UUID

data class ProductInventory(
    val id: UUID,
    val productId: UUID,
    val stockCount: Int,
    val createdAt: Instant,
    val updatedAt: Instant
)