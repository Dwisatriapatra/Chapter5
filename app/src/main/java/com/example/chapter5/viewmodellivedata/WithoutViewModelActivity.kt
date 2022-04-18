package com.example.chapter5.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter5.R
import kotlinx.android.synthetic.main.activity_without_view_model.*

class WithoutViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_view_model)

        var angka = 0
        btn_tambah_without_vm.setOnClickListener {
            text_number_without_vm.text = (++angka).toString()
        }
        btn_kurang_without_vm.setOnClickListener {
            text_number_without_vm.text = (--angka).toString()
        }
    }
}