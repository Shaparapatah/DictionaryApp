package com.shaparapatah.dictionaryapp.di


import androidx.room.Room
import com.shaparapatah.dictionaryapp.view.main.MainInteractor
import com.shaparapatah.dictionaryapp.view.main.MainViewModel
import com.shaparapatah.historyscreen.view.history.HistoryInteractor
import com.shaparapatah.historyscreen.view.history.HistoryViewModel
import com.shaparapatah.model.data.DataModel
import com.shaparapatah.repository.*
import com.shaparapatah.repository.room.HistoryDataBase
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