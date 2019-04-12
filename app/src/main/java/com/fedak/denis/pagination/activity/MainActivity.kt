package com.fedak.denis.pagination.activity

import android.os.Bundle
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.fedak.denis.pagination.R
import com.fedak.denis.pagination.adapter.MainAdapterNew
import com.fedak.denis.pagination.adapter.PostDiffUtilCallback
import com.fedak.denis.pagination.model.ItemStackOverflow
import com.fedak.denis.pagination.mvp_view.MainViewMVP
import com.fedak.denis.pagination.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity(), MainViewMVP {

    private val presenter: MainPresenter by inject()

    private lateinit var adapter: MainAdapterNew
    private lateinit var pagedList: PagedList<ItemStackOverflow>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.view = this
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = MainAdapterNew(PostDiffUtilCallback())
        postRecyclerView.adapter = adapter
        postRecyclerView.layoutManager = LinearLayoutManager(this)
        presenter.createPagedList()
    }

    override fun initPagedList(pagedList: PagedList<ItemStackOverflow>) {
        this.pagedList = pagedList
        adapter.submitList(pagedList)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}