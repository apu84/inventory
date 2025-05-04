package com.example.inventory

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository: JpaRepository<Inventory, UUID>