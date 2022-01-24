package com.shaparapatah.dictionaryapp

import com.shaparapatah.dictionaryapp.di.NAME_LOCAL
import com.shaparapatah.dictionaryapp.di.NAME_REMOTE
import com.shaparapatah.dictionaryapp.model.data.DataModel
import com.shaparapatah.dictionaryapp.model.datasource.RetrofitImplementation
import com.shaparapatah.dictionaryapp.model.datasource.RoomDataBaseImplementation
import com.shaparapatah.dictionaryapp.model.repository.Repository
import com.shaparapatah.dictionaryapp.model.repository.RepositoryImplementation
import com.shaparapatah.dictionaryapp.view.main.MainInteractor
import com.shaparapatah.dictionaryapp.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/** Две переменные: в одной находятся зависимости, используемые во всём приложении,
во втрой - зависимости конкретного экрана
 * @param application - используется во всём приложении
 * @param mainScreen - зависимости конкретного экрана
 */

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImplementation(RetrofitImplementation())
    }

    /**  Функция single сообщает Koin, что эта зависимость должна храниться
    в виде синглтона (в Dagger есть похожая аннотация)
    Аннотация named выполняет аналогичную Dagger функцию */

    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImplementation(RoomDataBaseImplementation())
    }
}

/** Функция factory сообщает Koin, что эту зависимость нужно создавать каждый
раз заново, что как раз подходит для Activity и её компонентов */

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
