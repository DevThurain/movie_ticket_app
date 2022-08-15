package com.thurainx.movieticketapp.delegates

import com.thurainx.movieticketapp.data.vos.SnackVO

interface SnackDelegate {
    fun onTapAddSnack(snackVO: SnackVO)
    fun onTapRemoveSnack(snackVO: SnackVO)

}