package com.example.android_architecture_patterns

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_architecture_patterns.databinding.ActivityMainBinding
import com.example.android_architecture_patterns.mvc.MvcActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 데이터 바인딩
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }
    }

    fun openMvc(){
        startActivity(Intent(this, MvcActivity::class.java))
    }

    fun openMvp(){

    }

    fun openMvvm() {

    }

    fun openMvi(){

    }
}