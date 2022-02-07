package com.shaparapatah.dictionaryapp.view.main

import com.shaparapatah.core.viewmodel.Interactor
import com.shaparapatah.model.data.AppState
import com.shaparapatah.model.data.DataModel
import com.shaparapatah.repository.Repository
import com.shaparapatah.repository.RepositoryLocal

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}
