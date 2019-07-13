package com.danieloliveira138.feedme.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira138.feedme.ui.post.PostAdapter

//@file:Suppress("unused")

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: PostAdapter) {
    view.adapter = adapter
}

@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager){
    view.layoutManager = layoutManager
}

@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: DividerItemDecoration){
    view.addItemDecoration(dividerItemDecoration)
}