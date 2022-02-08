package com.shaparapatah.repository

import com.shaparapatah.model.data.DataModel
import com.shaparapatah.repository.DataSource
import com.shaparapatah.repository.Repository

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
