package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Product {
    @SerialName("product_1") Product1,
    @SerialName("product_2") Product2,
}