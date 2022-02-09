package com.shaparapatah.dictionaryapp.view.main

import com.shaparapatah.core.viewmodel.Interactor
import com.shaparapatah.dictionaryapp.utils.mapSearchResultToResult
import com.shaparapatah.model.data.AppState
import com.shaparapatah.model.data.dto.SearchResultDto
import com.shaparapatah.repository.Repository
import com.shaparapatah.repository.RepositoryLocal

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}
