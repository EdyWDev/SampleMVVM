package com.example.mymvvmsample.service

import com.example.mymvvmsample.model.CatFactDTO

class CatFactRepository(
    private val catFactService: CatFactService
) {
    suspend fun getCatFact(): CatFactDTO = catFactService.getCatFact()
}