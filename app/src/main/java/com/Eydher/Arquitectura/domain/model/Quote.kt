package com.Eydher.Arquitectura.domain.model

import com.Eydher.Arquitectura.data.database.entities.QuoteEntity
import com.Eydher.Arquitectura.data.model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)