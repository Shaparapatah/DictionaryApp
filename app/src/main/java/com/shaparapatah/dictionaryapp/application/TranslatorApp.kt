package com.shaparapatah.dictionaryapp.application

import android.app.Application
import com.shaparapatah.dictionaryapp.application
import com.shaparapatah.dictionaryapp.mainScreen
import org.koin.core.context.startKoin

/** Инициализация Koin в приложении
 * @param startKoin
 * Важная деталь - Нужно убедиться, что TranslatorApp прописан в Manifests */

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}