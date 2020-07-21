package com.jjmin.focus.ui.home

import com.jjmin.focus.ui.base.BaseContract

interface HomeContract{

    interface View : BaseContract.View {
        fun loadUI()
    }

    interface Presenter : BaseContract.Presenter{
        fun loadUI()
        fun updateTheme() : Int
        fun accessTime()
    }

}