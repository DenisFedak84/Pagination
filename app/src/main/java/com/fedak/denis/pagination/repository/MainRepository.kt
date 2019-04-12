package com.fedak.denis.pagination.repository

import com.fedak.denis.pagination.model.StackOverflowModel

interface MainRepository {

    suspend fun getDataInternal(pageNumber: Int, pageSize: Int): StackOverflowModel?
}