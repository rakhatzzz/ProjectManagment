package com.example.projectmanagment.network

import com.example.projectmanagment.data.Course
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

object EduPwlApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

private const val BASE_URL = "https://"

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType()))
    .build()

interface ApiService {

    @GET("/api/sollections")
    suspend fun getListCourses(
        @Query("type") type: String
    ): List<Course>


    @GET("/api/course/{id}")
    suspend fun getCourse(
        @Path("id") id: Int
    ): Course



}