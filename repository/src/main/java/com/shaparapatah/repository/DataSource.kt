package com.shaparapatah.repository

interface DataSource<T> {

    suspend fun getData(word: String): T
}
