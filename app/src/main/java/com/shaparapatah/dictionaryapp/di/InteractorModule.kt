package com.shaparapatah.dictionaryapp.di

import com.shaparapatah.dictionaryapp.model.data.DataModel
import com.shaparapatah.dictionaryapp.model.repository.Repository
import com.shaparapatah.dictionaryapp.view.main.MainInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}