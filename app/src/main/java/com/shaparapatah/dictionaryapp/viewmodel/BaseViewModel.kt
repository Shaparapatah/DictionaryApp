package com.shaparapatah.dictionaryapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shaparapatah.dictionaryapp.model.data.AppState
import kotlinx.coroutines.*

abstract class BaseViewModel<T : AppState>(
    protected open val _mutableLiveData: MutableLiveData<T> = MutableLiveData()
) : ViewModel() {

    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }

    protected fun cancelJob() {

        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    abstract fun getData(word: String, isOnline: Boolean)

    abstract fun handleError(error: Throwable)

}


//    /** LiveData - хранилище данных, работающее по приципу паттерна Observer(наблюдатель)
//     * 1. В него можно поместить какой-либо объект
//     * 2. На него можно подписаться и получать объекты, которые в него помещают
//     * **/
//    protected val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
//    /** CompositeDisposable - это набор Disposable для отмены длительной асинхронной операции
//     * 1. Зазгрузка ЦП
//     * 2. Разгрузка памяти
//     */
//    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
//    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
//) : ViewModel() {
//
//    abstract fun getData(word: String, isOnline: Boolean)
//
//    override fun onCleared() {
//        compositeDisposable.clear()
//    }
