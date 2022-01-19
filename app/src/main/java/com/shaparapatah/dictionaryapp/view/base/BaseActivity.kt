package com.shaparapatah.dictionaryapp.view.base

import androidx.appcompat.app.AppCompatActivity
import com.shaparapatah.dictionaryapp.BaseViewModel
import com.shaparapatah.dictionaryapp.model.data.AppState

abstract class BaseActivity<T : AppState> : AppCompatActivity() /*View*/ {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)
}




/** Изменение от MVP до MVVM**/

//    protected lateinit var presenter: Presenter<T, View>
//
//    protected abstract fun createPresenter(): Presenter<T, View>
//
//    abstract override fun renderData(appState: AppState)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        presenter = createPresenter()
//    }
//
//    override fun onStart() {
//        super.onStart()
//        presenter.attachView(this)
//    }
//
//    override fun onStop() {
//        super.onStop()
//        presenter.detachView(this)

