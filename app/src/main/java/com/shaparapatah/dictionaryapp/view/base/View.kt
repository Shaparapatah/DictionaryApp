package com.shaparapatah.dictionaryapp.view.base

import com.shaparapatah.dictionaryapp.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}