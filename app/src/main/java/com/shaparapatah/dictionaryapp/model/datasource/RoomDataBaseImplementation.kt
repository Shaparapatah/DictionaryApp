package com.shaparapatah.dictionaryapp.model.datasource

import com.shaparapatah.dictionaryapp.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("Not yet implemented")
    }
}