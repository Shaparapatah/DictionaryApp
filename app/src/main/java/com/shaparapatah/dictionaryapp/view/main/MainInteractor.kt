package com.shaparapatah.dictionaryapp.view.main

import com.shaparapatah.dictionaryapp.model.data.AppState
import com.shaparapatah.dictionaryapp.model.data.DataModel
import com.shaparapatah.dictionaryapp.model.repository.Repository
import com.shaparapatah.dictionaryapp.viewmodel.Interactor

/** Извлекаем данные из БД и Интернета и отправляем в Presenter
 * Интерактор скрывает работу с хранилищем или веб-сервисом.
 * Работает через интерфейс */

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}