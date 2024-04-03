package com.example.android_architecture_patterns.mvi

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.android_architecture_patterns.databinding.ActivityMviBinding
import com.example.android_architecture_patterns.mvi.repository.ImageRepositoryImpl
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch

class MviActivity: AppCompatActivity() {

    // retrofit오류가 나는데 시간나면 고치겠습니다.

    private val viewModel : MviViewModel by viewModels {
        MviViewModel.MviViewModelFactory(ImageRepositoryImpl())
    }
    private lateinit var binding: ActivityMviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMviBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }
        observeViewModel()
    }
    fun loadImage(){
        lifecycleScope.launch {
            viewModel.channel.send(MviIntent.LoadImage)
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.state.collectLatest { state->
                when(state){
                    is MviState.Idle -> {
                        binding.progressView.isVisible = false
                    }
                    is MviState.Loading -> {
                        binding.progressView.isVisible = true
                    }
                    is MviState.LoadedImage -> {
                        binding.progressView.isVisible = false
                        binding.imageView.run {
                            setBackgroundColor(Color.parseColor(state.image.color))
                            load(state.image.url){
                                crossfade(300)
                            }
                        }
                        binding.imageCountTextView.text = "불러온 이미지 수 : ${state.count}"
                    }
                }
            }
        }
    }
}