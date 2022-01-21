package com.shaparapatah.dictionaryapp.view.main

import com.shaparapatah.dictionaryapp.di.NAME_LOCAL
import com.shaparapatah.dictionaryapp.di.NAME_REMOTE
import com.shaparapatah.dictionaryapp.model.data.AppState
import com.shaparapatah.dictionaryapp.model.data.DataModel
import com.shaparapatah.dictionaryapp.model.repository.Repository
import com.shaparapatah.dictionaryapp.viewmodel.Interactor
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

/** Извлекаем данные из БД и Интернета и отправляем в Presenter
 * Интерактор скрывает работу с хранилищем или веб-сервисом.
 * Работает через интерфейс */

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote.getData(word).map { AppState.Success(it) }
        } else {
            repositoryLocal.getData(word).map { AppState.Success(it) }
        }
    }
}