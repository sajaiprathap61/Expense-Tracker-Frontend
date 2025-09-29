package com.example.expensetracker.data.model

import kotlinx.serialization.Serializable

@Serializable
data class HomeScreen(
    val id: Int,
    val title: String,
    val body: String
)