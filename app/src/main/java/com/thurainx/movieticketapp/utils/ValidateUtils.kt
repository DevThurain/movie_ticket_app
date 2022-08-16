package com.thurainx.movieticketapp.utils

import android.widget.EditText

fun EditText.validateEmpty(errorMessage : String): Boolean{
    if(this.text.isEmpty()){
        this.error = errorMessage
        return false
    }
    return true
}

fun EditText.validateEmail() : Boolean{
    if (this.text.isEmpty()) {
        this.error = "email cannot be empty."
    } else {
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()){
            this.error = "invalid email"
            return false
        }
        return true
    }
    return false
}

fun EditText.validatePhone(): Boolean{
    if (text.isEmpty()) {
        this.error = "phone number cannot be empty."

    } else {
        if(text.toString().toLongOrNull() == null){
            this.error = "invalid phone"
            return false
        }
        return true
    }

    return false

}
