package com.helliomessaging.android

import android.content.Context
import android.os.Build
import android.widget.Toast


fun isMarshmallowPlus() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

fun Context.toast(id: Int) {
        Toast.makeText(this,getString(id),Toast.LENGTH_LONG).show()

}
