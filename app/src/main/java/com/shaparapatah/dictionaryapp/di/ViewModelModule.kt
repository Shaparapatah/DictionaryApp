package com.shaparapatah.dictionaryapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shaparapatah.dictionaryapp.view.main.MainViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/** ViewModelModule послужит источником коллекции ViewModel`ей для фабрики:
 * мы используем этот модуль для создания ViewModel
 * мы предоставляем ключ для каждой новой ViewModel при помощи класса ViewModelKey, созданного ранее
и уже в Activity мы используем фабрику для создания нужной нам ViewModel */

@Module(includes = [InteractorModule::class])
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    /** Этот метод просто говорит Dagger`у: помести эту модель в списко (map) моделей,
    используй аннотацию @IntoMap, где в качестве ключа будет класс - MainViewModel::class */

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    protected abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel
}