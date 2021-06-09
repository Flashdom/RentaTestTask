package com.rentateamtest.test.util

import androidx.multidex.MultiDexApplication
import com.rentateamtest.test.di.components.AppComponent
import com.rentateamtest.test.di.components.DaggerAppComponent
import com.rentateamtest.test.di.modules.AppModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


class MyApp : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(
                AppModule(this)
            ).build()
    }

    companion object {
        var component: AppComponent? = null
    }
}