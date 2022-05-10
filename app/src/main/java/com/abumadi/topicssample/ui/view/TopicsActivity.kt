package com.abumadi.topicssample.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abumadi.topicssample.R


class TopicsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val allTopicsFragment = AllTopicsFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, allTopicsFragment)
        transaction.commit()
    }
}