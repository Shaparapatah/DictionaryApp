package com.shaparapatah.historyscreen.view.history

import com.shaparapatah.core.viewmodel.Interactor
import com.shaparapatah.model.data.AppState
import com.shaparapatah.model.data.DataModel
import com.shaparapatah.repository.Repository
import com.shaparapatah.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
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
