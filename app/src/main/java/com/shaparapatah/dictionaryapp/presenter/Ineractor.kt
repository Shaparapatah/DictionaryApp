package com.shaparapatah.dictionaryapp.presenter

import java.util.*

interface Ineractor<T> {

    fun getData(word: String, fromRemoteSource : Boolean) : Observable<T>
}