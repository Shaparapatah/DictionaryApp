package com.shaparapatah.dictionaryapp.model.datasource

import com.shaparapatah.dictionaryapp.model.data.DataModel
import io.reactivex.Observable

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("Not yet implemented")
    }
}