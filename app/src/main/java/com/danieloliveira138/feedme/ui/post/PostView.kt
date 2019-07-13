package com.danieloliveira138.feedme.ui.post

import androidx.annotation.StringRes
import com.danieloliveira138.feedme.base.BaseView
import com.danieloliveira138.feedme.model.Post

interface PostView: BaseView {

    fun updatePosts(posts: List<Post>)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int){
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()

}