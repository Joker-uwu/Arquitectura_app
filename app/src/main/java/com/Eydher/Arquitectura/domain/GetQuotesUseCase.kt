package com.Eydher.Arquitectura.domain

import com.Eydher.Arquitectura.data.QuoteRepository
import com.Eydher.Arquitectura.data.database.entities.toDatabase
import com.Eydher.Arquitectura.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }
}