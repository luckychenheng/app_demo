package com.developers.apollographqlexample

import android.content.Context
import android.widget.Toast

/**
 * Created by lucky on 19/3/14
 */
fun Context.showToast(msg: String) {
    Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
}