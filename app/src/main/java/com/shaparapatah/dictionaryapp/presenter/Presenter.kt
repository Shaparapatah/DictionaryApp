package com.shaparapatah.dictionaryapp.presenter

import com.shaparapatah.dictionaryapp.model.data.AppState
import com.shaparapatah.dictionaryapp.view.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}