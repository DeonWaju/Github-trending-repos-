package com.softcom.ui.mvvm

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.softcom.R
import com.softcom.base.BaseViewModel
import com.softcom.model.Items
import com.softcom.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GithubListViewModel : BaseViewModel() {

    @Inject
    lateinit var apiService: ApiService

    val githubListAdapter: GithubListAdapter = GithubListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadGithubUser() }

    init {
        loadGithubUser()
    }


    @SuppressLint("CheckResult")
    private fun loadGithubUser() {
        apiService.getGithubUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onLoad() }
            .doOnTerminate { onFinish() }
            .subscribe(
                { result -> onSuccess(result.items) },
                { error ->
                    Log.e("", error.toString())
                    onError()
                }
            )
    }

    private fun onLoad() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onSuccess(items: List<Items>) {
        githubListAdapter.updateGithubUserList(items)
    }

    private fun onError() {
        errorMessage.value = R.string.error
    }
}