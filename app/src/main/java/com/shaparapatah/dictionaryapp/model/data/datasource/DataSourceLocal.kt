package com.shaparapatah.dictionaryapp.model.data.datasource

import com.shaparapatah.dictionaryapp.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}
