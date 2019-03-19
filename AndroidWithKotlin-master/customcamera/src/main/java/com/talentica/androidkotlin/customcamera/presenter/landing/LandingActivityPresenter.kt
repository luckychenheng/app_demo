package com.talentica.androidkotlin.customcamera.presenter.landing

import android.support.design.widget.NavigationView
import android.widget.GridView
import com.talentica.androidkotlin.customcamera.presenter.ActivityPresenter
import com.talentica.androidkotlin.customcamera.ui.landing.LandingActivityView

interface LandingActivityPresenter : ActivityPresenter<LandingActivityView>, NavigationView.OnNavigationItemSelectedListener {

    fun addListOfPicsToAdapter(gridView: GridView)
    fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray)
    fun lauchPhotoPreview(position:Int)
}