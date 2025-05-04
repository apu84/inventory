package com.example.inventory

import jakarta.persistence.*
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "inventory")
data class Inventory(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(nullable = false, name = "product_id")
    val productId: UUID,

    @Column(nullable = false, name = "stock_count")
    val stockCount: Int,

    @Column(nullable = false, name = "created_at", updatable = false)
    val createdAt: Instant = Instant.now(),

    @Column(nullable = false, name = "updated_at")
    val updatedAt: Instant = Instant.now(),

    @Version
    @Column(nullable = false, name = "version")
    var version: Long = 0
)