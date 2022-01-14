package com.shaparapatah.dictionaryapp.repository

import java.util.*

interface Repository<T> {

    fun getData(word :String): Observable<T>
}