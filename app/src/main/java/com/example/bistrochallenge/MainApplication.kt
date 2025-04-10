package com.example.bistrochallenge

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : android.app.Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any necessary components here
    }
}