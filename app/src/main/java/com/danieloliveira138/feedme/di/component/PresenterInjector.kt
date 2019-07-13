package com.danieloliveira138.feedme.di.component

import com.danieloliveira138.feedme.base.BaseView
import com.danieloliveira138.feedme.di.module.ContextModule
import com.danieloliveira138.feedme.di.module.NetworkModule
import com.danieloliveira138.feedme.ui.post.PostPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
abstract class PresenterInjector {

    abstract fun inject(postPresenter: PostPresenter)

    @Component.Builder
    interface Builder {

        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder

        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder

    }
}