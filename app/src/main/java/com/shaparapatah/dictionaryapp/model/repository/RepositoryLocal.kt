package com.shaparapatah.dictionaryapp.model.repository

import com.shaparapatah.dictionaryapp.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
