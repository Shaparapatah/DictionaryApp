package com.shaparapatah.dictionaryapp.model.data.datasource

interface DataSource<T> {

    suspend fun getData(word: String): T
}
