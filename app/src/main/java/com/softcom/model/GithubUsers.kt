package com.softcom.model

data class GithubUsers(
    val total_count: Int = 0,
    val incomplete_results: Boolean,
    val items: List<Items>
)