package com.example.topdealtask.util

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject


fun SearchView.fromView(searchView: SearchView): Observable<String> {

    val subject = PublishSubject.create<String>()

    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(s: String): Boolean {
            subject.onComplete()
            return true
        }

        override fun onQueryTextChange(text: String): Boolean {
            subject.onNext(text)
            return true
        }
    })

    return subject
}

fun EditText.onTextChangesObservable(): Observable<String> {
    val subject = BehaviorSubject.create<String>()

    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            subject.onNext(p0.toString())
        }
    })

    return subject
}

fun TextView.clear() {
    this.text = ""
}

fun View.enable() {
    this.isEnabled = true
}
fun View.disable() {
    this.isEnabled = false
}


 fun Activity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
fun View.hideKeyboard(context: Context?) {
    try {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    } catch (e: Exception) {
        e.printStackTrace()
    }

}
