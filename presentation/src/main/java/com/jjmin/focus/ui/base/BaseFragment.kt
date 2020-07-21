package com.jjmin.focus.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.jetbrains.anko.support.v4.toast


abstract class BaseFragment : Fragment() , BaseContract.View {

    abstract var initLayoutResourse : Int

    override fun toastMessage(text: String) {
        toast(text)
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(initLayoutResourse, container, false)
//    }
}