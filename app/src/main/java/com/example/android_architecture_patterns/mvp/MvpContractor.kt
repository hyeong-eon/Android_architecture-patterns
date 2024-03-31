package com.example.android_architecture_patterns.mvp

interface MvpContractor {
    // 인터페이스에서 뷰와 프리젠터를 연결함
    interface View{
        fun showImage(url:String, color:String)

        fun showImageCountText(count: Int)
    }
    interface Presenter{
        fun attachView(view:View)

        fun detachView()

        fun loadRandomImage()
    }
}