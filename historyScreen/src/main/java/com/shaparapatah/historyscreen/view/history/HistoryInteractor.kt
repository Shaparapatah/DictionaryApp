package com.shaparapatah.historyscreen.view.history

import com.shaparapatah.core.viewmodel.Interactor
import com.shaparapatah.historyscreen.mapSearchResultToResult
import com.shaparapatah.model.data.AppState
import com.shaparapatah.model.data.dto.SearchResultDto
import com.shaparapatah.repository.Repository
import com.shaparapatah.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}
