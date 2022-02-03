package com.shaparapatah.dictionaryapp.model.repository

import com.shaparapatah.dictionaryapp.model.data.DataModel
import com.shaparapatah.dictionaryapp.model.data.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
