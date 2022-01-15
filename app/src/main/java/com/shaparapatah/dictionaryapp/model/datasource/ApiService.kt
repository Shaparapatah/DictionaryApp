package com.shaparapatah.dictionaryapp.model.datasource

import com.shaparapatah.dictionaryapp.model.data.DataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<DataModel>>
}