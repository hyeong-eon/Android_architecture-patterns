package com.example.android_architecture_patterns.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_architecture_patterns.mvvm.model.Image
import com.example.android_architecture_patterns.mvvm.repository.ImageRepository
import io.reactivex.disposables.CompositeDisposable

class MvvmViewModel(private val imageRepository: ImageRepository): ViewModel() {

    // LiveData
    private val _countLiveData = MutableLiveData<String>()
    val countLiveData : LiveData<String> by lazy { _countLiveData }

    private val _imageLiveData = MutableLiveData<Image>()
    val imageLiveData : LiveData<Image> by lazy { _imageLiveData }

    private var disposable : CompositeDisposable? = CompositeDisposable()
    private var count = 0

    fun loadRandomImage(){
        disposable?.add(imageRepository.getRandomImage()
            .doOnSuccess{
                count++
            }
            .subscribe{ item ->
                _imageLiveData.value = item
                _countLiveData. value = "불러온 이미지 수 : ${count}"
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable = null
    }
    class MvvmViewModelFactory(private val imageRepository: ImageRepository) :
            ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MvvmViewModel(imageRepository) as T
        }
    }
}