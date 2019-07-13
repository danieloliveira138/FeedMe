package com.danieloliveira138.feedme.network

import com.danieloliveira138.feedme.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>

}