package com.example.mymvvmsample.service

import com.example.mymvvmsample.model.CatFact
import com.example.mymvvmsample.service.model.CatFactDTO

class CatFactRepository(
    private val catFactService: CatFactService
) {
    suspend fun getCatFact(): CatFact = catFactService.getCatFact().toDomainModel()
}

fun CatFactDTO.toDomainModel() : CatFact{
    return CatFact(
        fact = fact,
        length = length
    )
}