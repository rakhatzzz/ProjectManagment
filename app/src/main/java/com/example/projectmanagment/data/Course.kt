package com.example.projectmanagment.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Course(
    @SerialName("id")
    val id: Int,
    @SerialName("course_name")
    val name: String,
    @SerialName("small_description")
    val small_descr: String?=null,
    @SerialName("posterurl")
    val poster: String,
    @SerialName("description")
    val description: String

)
