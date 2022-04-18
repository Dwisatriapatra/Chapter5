package com.example.chapter5.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chapter5.R
import com.example.chapter5.viewmodellivedata.viewmodel.ViewModelSatu
import kotlinx.android.synthetic.main.activity_using_view_model.*

class UsingViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_using_view_model)

        val viewModel = ViewModelProvider(this).get(ViewModelSatu::class.java)

        text_number_using_vm.text = viewModel.number.toString()
            btn_tambah_using_vm.setOnClickListener {
            viewModel.number++
            text_number_using_vm.text = viewModel.number.toString()
        }

        btn_kurang_using_vm.setOnClickListener {
            viewModel.number--
            text_number_using_vm.text = viewModel.number.toString()
        }
    }
}