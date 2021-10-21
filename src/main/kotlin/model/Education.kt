package model

import kotlinx.serialization.Serializable

@Serializable
data class Education(
    val elementarySchool: String? = null,
    val juniorHighSchool: String? = null,
    val seniorHighSchool: String? = null,
    val college: String? = null
) {
}