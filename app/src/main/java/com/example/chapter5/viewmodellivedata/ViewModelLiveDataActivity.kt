package com.example.chapter5.viewmodellivedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter5.R
import kotlinx.android.synthetic.main.activity_view_model_live_data.*

class ViewModelLiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_live_data)

        without_viewmodel.setOnClickListener {
            startActivity(Intent(this, WithoutViewModelActivity::class.java))
        }
        using_viewmodel.setOnClickListener {
            startActivity(Intent(this, UsingViewModelActivity::class.java))
        }
        using_viewmodel_livedata.setOnClickListener {
            startActivity(Intent(this, UsingViewModelLiveDataActivity::class.java))
        }
    }
}