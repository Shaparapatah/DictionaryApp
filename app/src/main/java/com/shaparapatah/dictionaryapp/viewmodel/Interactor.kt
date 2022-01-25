package com.shaparapatah.dictionaryapp.viewmodel

/** Интерфейс, который скрывает работу Интерактора */

interface Interactor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}