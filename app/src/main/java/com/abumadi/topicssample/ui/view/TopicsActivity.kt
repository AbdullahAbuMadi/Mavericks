package com.abumadi.topicssample.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abumadi.topicssample.R
import com.airbnb.mvrx.Mavericks


class TopicsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Mavericks.initialize(this.applicationContext)
        
        val allTopicsFragment = AllTopicsFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, allTopicsFragment)
        transaction.commit()
    }
}