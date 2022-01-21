package com.shaparapatah.dictionaryapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shaparapatah.dictionaryapp.model.data.AppState
import com.shaparapatah.dictionaryapp.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T : AppState>(
    /** LiveData - хранилище данных, работающее по приципу паттерна Observer(наблюдатель)
     * 1. В него можно поместить какой-либо объект
     * 2. На него можно подписаться и получать объекты, которые в него помещают
     * **/
    protected val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
    /** CompositeDisposable - это набор Disposable для отмены длительной асинхронной операции
     * 1. Зазгрузка ЦП
     * 2. Разгрузка памяти
     */
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {

    abstract fun getData(word: String, isOnline: Boolean)

    override fun onCleared() {
        compositeDisposable.clear()
    }
}