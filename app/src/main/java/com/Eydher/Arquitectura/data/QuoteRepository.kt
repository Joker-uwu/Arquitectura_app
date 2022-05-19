package com.Eydher.Arquitectura.data

import com.Eydher.Arquitectura.data.database.dao.QuoteDao
import com.Eydher.Arquitectura.data.database.entities.QuoteEntity
import com.Eydher.Arquitectura.data.model.QuoteModel
import com.Eydher.Arquitectura.data.network.QuoteService
import com.Eydher.Arquitectura.domain.model.Quote
import com.Eydher.Arquitectura.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}