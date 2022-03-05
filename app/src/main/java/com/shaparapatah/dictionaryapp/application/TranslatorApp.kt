package com.shaparapatah.dictionaryapp.application

import android.app.Application
import com.shaparapatah.dictionaryapp.di.application
import com.shaparapatah.dictionaryapp.di.historyScreen
import com.shaparapatah.dictionaryapp.di.mainScreen
import org.koin.android.ext.koin.androidContext

import org.koin.core.context.startKoin

/** Инициализация Koin в приложении
 * @param startKoin
 * Важная деталь - Нужно убедиться, что TranslatorApp прописан в Manifests */

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}