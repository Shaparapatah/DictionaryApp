package com.shaparapatah.dictionaryapp.model.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
