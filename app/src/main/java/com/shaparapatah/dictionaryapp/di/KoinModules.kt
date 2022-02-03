package com.shaparapatah.dictionaryapp.di

import androidx.room.Room
import com.shaparapatah.dictionaryapp.model.data.DataModel
import com.shaparapatah.dictionaryapp.model.data.datasource.RetrofitImplementation
import com.shaparapatah.dictionaryapp.model.data.datasource.RoomDataBaseImplementation
import com.shaparapatah.dictionaryapp.model.repository.Repository
import com.shaparapatah.dictionaryapp.model.repository.RepositoryImplementation
import com.shaparapatah.dictionaryapp.model.repository.RepositoryImplementationLocal
import com.shaparapatah.dictionaryapp.model.repository.RepositoryLocal
import com.shaparapatah.dictionaryapp.room.HistoryDataBase
import com.shaparapatah.dictionaryapp.view.history.HistoryInteractor
import com.shaparapatah.dictionaryapp.view.history.HistoryViewModel
import com.shaparapatah.dictionaryapp.view.main.MainInteractor
import com.shaparapatah.dictionaryapp.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> {
        RepositoryImplementationLocal(
            RoomDataBaseImplementation(get())
        )
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}