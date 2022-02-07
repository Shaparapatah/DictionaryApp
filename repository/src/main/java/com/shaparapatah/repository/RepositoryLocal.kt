package com.shaparapatah.repository

import com.shaparapatah.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
