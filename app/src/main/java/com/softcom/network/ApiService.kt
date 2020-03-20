package com.softcom.network

import com.softcom.model.GithubUsers
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("/search/repositories?q=android+language:java+language:kotlin&sort=stars&order=desc")
    fun getGithubUsers(): Flowable<GithubUsers>
}
