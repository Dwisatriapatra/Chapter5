package com.example.chapter5.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chapter5.R
import com.example.chapter5.viewmodellivedata.viewmodel.ViewModelDua
import kotlinx.android.synthetic.main.activity_using_view_model_live_data.*
import kotlin.math.absoluteValue

class UsingViewModelLiveDataActivity : AppCompatActivity() {
    private lateinit var viewModel : ViewModelDua
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_using_view_model_live_data)

        viewModel = ViewModelProvider(this).get(ViewModelDua::class.java)
        viewModel.addNumber.observe(this, Observer{
            text_number_using_vm_ld.text = it.toString()
        })
        viewModel.lessNumber.observe(this, Observer {
            text_number_using_vm_ld.text = it.toString()
        })
        btn_tambah_using_vm_ld.setOnClickListener {
            viewModel.addNumber.value = ++viewModel.number
        }
        btn_kurang_using_vm_ld.setOnClickListener {
            viewModel.lessNumber.value = --viewModel.number
        }
    }
}