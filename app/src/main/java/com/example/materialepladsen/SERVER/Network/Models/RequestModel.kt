package com.example.materialepladsen.SERVER.Network.Models

import kotlinx.serialization.Serializable

@Serializable
data class RequestModel(
//    val title: String,
//    val description: String,
//    val image: String
    val group: String,
    val id: String,
    val articleNumber: String,
    val articleName: String,
    val size: String?,
    val weightM3: String,
    val priceExcludeTax: String,
    val priceIncludeTax: String,
    val unit: String,
    val availability: String?,
    val imageURL: String?
)
