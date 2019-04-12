package com.fedak.denis.pagination.mvp_view

import androidx.paging.PagedList
import com.fedak.denis.pagination.model.ItemStackOverflow

interface MainViewMVP {
     fun initPagedList(pagedList: PagedList<ItemStackOverflow>)
}