package com.navarayan.extensionfunctions

import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.graphics.applyCanvas

//Check if the number is in a range or not.
fun Int.inRange(from: Int, to: Int): Boolean {
    return this in from..to + 1
}

//Check if the number is prime or not. O(n)
fun Int.isPrime(): Boolean {
    if (this <= 1) return false
    if (this <= 3) return true
    if (this % 2 == 0 || this % 3 == 0) return false
    var i = 5
    while (i * i <= this) {
        if (this % i == 0 || this % (i + 2) == 0) return false
        i += 6
    }
    return true
}

//Taking screenshot from View (Not work in onCreate())
fun View.screenShot(): Bitmap {
    val bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888)
    bitmap.applyCanvas {
        translate(-scrollX.toFloat(), -scrollY.toFloat())
        draw(this)
    }
    return bitmap
}

//Hiding Keyboard
fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}