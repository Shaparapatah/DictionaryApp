package com.shaparapatah.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
