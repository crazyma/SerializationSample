package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Persona(
    @SerialName("name") val name: String,
    @SerialName("age") val age: Int,
    @SerialName("product") val product: Product? = null,
) {
}