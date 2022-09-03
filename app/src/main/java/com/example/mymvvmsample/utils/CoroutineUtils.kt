package com.example.mymvvmsample.utils

import androidx.lifecycle.MutableLiveData

suspend fun <T> callApi(
    sourceToUpdate: MutableLiveData<T>,
    actionToMake: suspend () -> T,
    actionOnError: (() -> Unit)? = null
) {
    try {
        sourceToUpdate.value = actionToMake.invoke()
    } catch (e: Exception) {
        // Retrofit error
        e.printStackTrace()
        actionOnError?.invoke()
    }
}