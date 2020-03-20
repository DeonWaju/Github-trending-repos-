package com.softcom.injection.component

import com.softcom.injection.module.NetworkModule
import com.softcom.ui.mvvm.GithubListViewModel
import com.softcom.ui.mvvm.GithubViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(githubListViewModel: GithubListViewModel)

    fun inject(githubViewModel: GithubViewModel)

    @Component.Builder
    interface Builder {

        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}