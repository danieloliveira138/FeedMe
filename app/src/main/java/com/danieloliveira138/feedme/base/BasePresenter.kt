package com.danieloliveira138.feedme.base

import com.danieloliveira138.feedme.di.component.DaggerPresenterInjector
import com.danieloliveira138.feedme.di.component.PresenterInjector
import com.danieloliveira138.feedme.di.module.ContextModule
import com.danieloliveira138.feedme.di.module.NetworkModule
import com.danieloliveira138.feedme.ui.post.PostPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    private val injector: PresenterInjector =
        DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated() {}

    open fun onViewDestroyed() {}

    private fun inject() {
        when(this){
            is PostPresenter -> injector.inject(this)
        }
    }
}