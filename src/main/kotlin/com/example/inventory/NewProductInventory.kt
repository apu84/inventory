package com.example.inventory

import java.util.UUID

data class NewProductInventory(
    val productId: UUID,
    val stockCount: Int
)