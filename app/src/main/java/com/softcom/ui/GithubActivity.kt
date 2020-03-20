package com.softcom.ui

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.softcom.R
import com.softcom.databinding.ActivityGithubUserBinding
import com.softcom.injection.ViewModelFactory
import com.softcom.ui.mvvm.GithubListViewModel

class GithubActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGithubUserBinding
    private lateinit var viewModel: GithubListViewModel
    private var errorSnackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_github_user)
        binding.githubUserRecycleView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(GithubListViewModel::class.java)

        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null)
                showError(errorMessage)
            else hideError()
        })

        binding.viewModel = viewModel
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackBar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackBar?.setAction("Retry", viewModel.errorClickListener)
        errorSnackBar?.show()
    }

    private fun hideError() {
        errorSnackBar?.dismiss()
    }
}