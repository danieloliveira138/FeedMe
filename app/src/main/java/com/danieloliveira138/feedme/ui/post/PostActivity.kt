package com.danieloliveira138.feedme.ui.post

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.danieloliveira138.feedme.R
import com.danieloliveira138.feedme.base.BaseActivity
import com.danieloliveira138.feedme.databinding.ActivityPostBinding
import com.danieloliveira138.feedme.model.Post

class PostActivity : BaseActivity<PostPresenter>(), PostView {

    private lateinit var binding: ActivityPostBinding

    private val postAdapter = PostAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        binding.adapter = postAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated()

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun instantiatePresenter(): PostPresenter =
        PostPresenter(this)

    override fun updatePosts(posts: List<Post>) {
        postAdapter.updatePosts(posts)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }
}
