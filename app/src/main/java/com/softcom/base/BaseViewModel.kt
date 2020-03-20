package com.softcom.base

import androidx.lifecycle.ViewModel
import com.softcom.injection.component.DaggerViewModelInjector
import com.softcom.injection.component.ViewModelInjector
import com.softcom.injection.module.NetworkModule
import com.softcom.ui.mvvm.GithubListViewModel
import com.softcom.ui.mvvm.GithubViewModel

abstract class BaseViewModel: ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject(){
        when(this) {
            is GithubListViewModel -> injector.inject(this)
            is GithubViewModel -> injector.inject(this)
        }
    }
}