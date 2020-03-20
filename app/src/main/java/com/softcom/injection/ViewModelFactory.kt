package com.softcom.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.softcom.ui.mvvm.GithubListViewModel
import java.lang.IllegalArgumentException


@Suppress("UNCHECKED_CAST")
class ViewModelFactory (private val activity: AppCompatActivity): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GithubListViewModel::class.java)){
//            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "github_user.db")
//                .build();
            return GithubListViewModel() as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class")
    }

}
