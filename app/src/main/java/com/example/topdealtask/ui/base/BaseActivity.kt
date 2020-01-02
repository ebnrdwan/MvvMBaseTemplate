package com.example.topdealtask.ui.base

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.topdealtask.util.Constants
import com.example.topdealtask.util.CustomContextWrapper


abstract class BaseActivity : AppCompatActivity() {
    abstract fun getLayout(): Int
    abstract fun initializeScreenComponents()
    fun setupToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initializeScreenComponents()
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CustomContextWrapper.wrap(newBase, Constants.Language.CURRENT))
    }

    override fun applyOverrideConfiguration(overrideConfiguration: Configuration) {
        super.applyOverrideConfiguration(baseContext.resources.configuration)
    }

}