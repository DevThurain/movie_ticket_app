package com.thurainx.movieticketapp.utils

import android.widget.EditText

fun EditText.validateEmpty(text: String,message : String): Boolean{
    if(text.toString().isEmpty()){
        this.error = message
        return false
    }
    return true
}

fun EditText.validateEmail(text: String) : Boolean{
    if (text.isEmpty()) {
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

fun EditText.validatePhone(text: String): Boolean{
    if (text.isEmpty()) {
        this.error = "phone number cannot be empty."

    } else {
        if(text.toLongOrNull() == null){
            this.error = "invalid phone"
            return false
        }
        return true
    }

    return false

}
