package com.shaparapatah.dictionaryapp.view

import com.shaparapatah.dictionaryapp.model.data.AppState

interface View {

    fun renderData(appState : AppState)
}