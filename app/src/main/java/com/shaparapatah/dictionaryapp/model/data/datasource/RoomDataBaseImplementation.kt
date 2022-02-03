package com.shaparapatah.dictionaryapp.model.data.datasource

import com.shaparapatah.dictionaryapp.model.data.AppState
import com.shaparapatah.dictionaryapp.model.data.DataModel
import com.shaparapatah.dictionaryapp.room.HistoryDao
import com.shaparapatah.dictionaryapp.utils.convertDataModelSuccessToEntity
import com.shaparapatah.dictionaryapp.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
