package com.softcom.ui.mvvm

import com.softcom.base.BaseViewModel
import com.softcom.model.Items
class GithubViewModel : BaseViewModel() {
    private var name: String = ""
    private var full_name: String = ""
    private var description: String = ""
    private var stargazers_count: Int = 0
    private var avatar_url: String = ""

    fun bind(item: Items) {
        name = item.name
        full_name = item.full_name
        description = item.description
        stargazers_count = item.stargazers_count
        avatar_url = item.avatar_url
    }

    fun getName(): String {
        return name;
    }

    fun getFullName(): String {
        return full_name;
    }

    fun getDescription(): String {
        return description;
    }

    fun getStargazersCount(): String {
        return stargazers_count.toString();
    }

    fun getAvatarUrl(): String {
        return avatar_url;
    }
}