package com.thurainx.movieticketapp.utils

import android.widget.EditText

fun EditText.validateEmpty(text: String,message : String){
    if(text.toString().isEmpty()){
        this.error = message
    }
}

fun EditText.validateEmail(text: String){
    if (text.isEmpty()) {
        this.error = "email cannot be empty."

    } else {
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()){
            this.error = "invalid email"
        }
    }
}

fun EditText.validatePhone(text: String){
    if (text.isEmpty()) {
        this.error = "phone number cannot be empty."

    } else {
        if(text.toIntOrNull() == null){
            this.error = "invalid phone"
        }
    }
}
