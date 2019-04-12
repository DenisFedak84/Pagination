package com.fedak.denis.pagination.network

import com.fedak.denis.pagination.model.StackOverflowModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkApi {

//    @GET("/2.2/answers?page={pageNumber}&pagesize=10&order=desc&sort=activity&site=stackoverflow")
//    fun getNotes(@Path("pageNumber") pageNumber: String): Deferred<StackOverflowModel>

    @GET("/2.2/answers?order=desc&sort=activity&site=stackoverflow")
    fun getNotes(@Query("page") pageNumber: Int, @Query("pagesize") pageSize: Int): Deferred<StackOverflowModel>
}