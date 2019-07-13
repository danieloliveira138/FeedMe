package com.danieloliveira138.feedme.ui.post

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.danieloliveira138.feedme.R
import com.danieloliveira138.feedme.databinding.ItemPostBinding
import com.danieloliveira138.feedme.model.Post

class PostAdapter(private val context: Context): RecyclerView.Adapter<PostViewHolder>() {

    private var posts = listOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding: ItemPostBinding = DataBindingUtil.inflate(view, R.layout.item_post, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    fun updatePosts(posts: List<Post>){
        this.posts = posts
        notifyDataSetChanged()
    }

}

class PostViewHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        binding.post = post
        binding.executePendingBindings()
    }
}