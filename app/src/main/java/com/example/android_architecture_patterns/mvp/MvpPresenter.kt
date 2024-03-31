package com.example.android_architecture_patterns.mvp

import com.example.android_architecture_patterns.mvp.model.ImageCountModel
import com.example.android_architecture_patterns.mvp.repository.ImageRepository

class MvpPresenter(
    private val model: ImageCountModel,
    private val imageRepository : ImageRepository
) : MvpContractor.Presenter, ImageRepository.CallBack {

    private var view: MvpContractor.View? = null
    override fun attachView(view: MvpContractor.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadRandomImage() {
        imageRepository.getRandomImage(this)
    }

    override fun loadImage(url: String, color: String) {
        model.increase()
        view?.showImage(url, color)
        view?.showImageCountText(model.count)
    }

}