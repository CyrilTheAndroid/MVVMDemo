package com.cyriltheandroid.mvvmdemo.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository {
    val dataSource = DataSource()

    fun getList() : Flow<List<String>> = flow {
        emit(dataSource.list)
    }
}