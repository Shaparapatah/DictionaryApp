package com.shaparapatah.dictionaryapp.viewmodel

import io.reactivex.Observable

/** Интерфейс, который скрывает работу Интерактора */

interface Interactor<T> {

    fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
}