package com.fedak.denis.pagination.data_source

import android.content.ContentValues.TAG
import android.util.Log
import androidx.paging.PositionalDataSource
import com.fedak.denis.pagination.model.ItemStackOverflow
import com.fedak.denis.pagination.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyDataSource (private val repo: MainRepository): PositionalDataSource<ItemStackOverflow>() {

    val MY_TAG = "Den"

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<ItemStackOverflow>) {

        Log.d(MY_TAG, "loadInitial, requestedStartPosition = " + params.requestedStartPosition +
                ", requestedLoadSize = " + params.requestedLoadSize)

        GlobalScope.launch(Dispatchers.Main) {
            val  result = repo.getDataInternal(params.requestedStartPosition + 1, params.requestedLoadSize)
            if (result != null) {
                if (params.placeholdersEnabled) {
                    callback.onResult(result.items,0,100)
                }else{
                    callback.onResult(result.items,0)
                }
            }
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ItemStackOverflow>) {

        Log.d(MY_TAG, "loadRange, startPosition = " + params.startPosition + ", loadSize = " + params.loadSize)

        GlobalScope.launch(Dispatchers.Main) {
            val result = repo.getDataInternal(params.startPosition +1, params.loadSize)
            if (result != null) {
                callback.onResult(result.items)
            }
        }
    }
}