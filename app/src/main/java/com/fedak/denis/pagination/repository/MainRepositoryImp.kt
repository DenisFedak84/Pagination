package com.fedak.denis.pagination.repository

import com.fedak.denis.pagination.model.StackOverflowModel
import com.fedak.denis.pagination.network.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MainRepositoryImp (private val api: NetworkApi) : MainRepository{

    override suspend fun getDataInternal(pageNumber:Int, pageSize: Int): StackOverflowModel? = withContext(Dispatchers.IO) { getData(pageNumber, pageSize) }

    suspend fun getData(pageNumber: Int, pageSize: Int): StackOverflowModel? {

        var stackoverflow: StackOverflowModel? = null

        try {
            stackoverflow = api.getNotes(pageNumber, pageSize).await()
        } catch (e: IOException) {
            println("Exception occurred")
        } catch (httpException: HttpException) {
            println("Http exception occurred")
        }

        return stackoverflow
    }
}