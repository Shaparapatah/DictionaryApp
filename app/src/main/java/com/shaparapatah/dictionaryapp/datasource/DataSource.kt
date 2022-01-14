package com.shaparapatah.dictionaryapp.datasource

import java.util.*

interface DataSource<T> {

    fun getData(word: String) : Observable<T>
}