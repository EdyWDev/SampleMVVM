package com.example.mymvvmsample.service

import com.example.mymvvmsample.model.CatFactDTO
import retrofit2.http.GET

interface CatFactService {
    @GET("fact")
    suspend fun getCatFact(): CatFactDTO
}