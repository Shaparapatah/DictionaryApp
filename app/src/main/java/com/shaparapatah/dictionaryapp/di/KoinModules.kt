package com.shaparapatah.dictionaryapp.di


import androidx.room.Room
import com.shaparapatah.dictionaryapp.view.main.MainActivity
import com.shaparapatah.dictionaryapp.view.main.MainInteractor
import com.shaparapatah.dictionaryapp.view.main.MainViewModel
import com.shaparapatah.historyscreen.view.history.HistoryActivity
import com.shaparapatah.historyscreen.view.history.HistoryInteractor
import com.shaparapatah.historyscreen.view.history.HistoryViewModel
import com.shaparapatah.model.data.dto.SearchResultDto
import com.shaparapatah.repository.*
import com.shaparapatah.repository.room.HistoryDataBase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}