package com.fedak.denis.pagination.presenter


import android.os.Handler

import com.fedak.denis.pagination.model.ItemStackOverflow
import com.fedak.denis.pagination.mvp_view.MainViewMVP
import com.fedak.denis.pagination.repository.MainRepository
import kotlinx.coroutines.Job
import java.util.concurrent.Executors
import android.os.Looper
import androidx.paging.PagedList
import com.fedak.denis.pagination.data_source.MyDataSource
import java.util.concurrent.Executor

class MainPresenter(private val repo: MainRepository) {

    var view: MainViewMVP? = null
    var job : Job? = null

    fun onDestroy() {
       job?.cancel()
    }

    fun createPagedList()  {

        val dataSource = MyDataSource(repo)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(10)
            .setInitialLoadSizeHint(10)
            .build()

        val pagedList = PagedList.Builder(dataSource, config)
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .setNotifyExecutor(MainThreadExecutor())
            .setInitialKey(1)
            .build()

        view?.initPagedList(pagedList)
    }


    internal inner class MainThreadExecutor : Executor {
        private val mHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mHandler.post(command)
        }
    }
}