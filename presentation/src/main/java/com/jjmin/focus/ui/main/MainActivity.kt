package com.jjmin.focus.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.BaseAdapter
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.jjmin.focus.R
import com.jjmin.focus.adapter.ListAdapter
import com.jjmin.focus.adapter.MainRecommentViewHolder
import com.jjmin.focus.model.ItemType
import com.jjmin.focus.ui.base.BaseActivity
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class MainActivity : BaseActivity() , MainContract.View ,
    DiscreteScrollView.OnItemChangedListener<MainRecommentViewHolder>,
    DiscreteScrollView.ScrollStateChangeListener<MainRecommentViewHolder>
{

    lateinit var adapter : ListAdapter

    override var initLayoutResourse: Int = R.layout.activity_main

    private val presenter : MainPresenter by inject{ parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ListAdapter(ItemType.MR,this).apply {
            adapter = this
        }

        presenter.accessTime()
        startVideo()
        settingPicker()

        presenter.dummyList.observe(this, Observer {
            Log.e("updateList",Gson().toJson(it))
            adapter.submitList(it?.toMutableList())
        })


        mainImg.setBackgroundResource(presenter.updateTheme())

        accessBtn.onClick {
            presenter.getAccessTime()
        }

    }

    override fun onResume() {
        super.onResume()
        startVideo()
    }

    override fun startVideo(){
        animationVideo.setVideoURI(presenter.videoUrl)
        animationVideo.start()
        animationVideo.setOnPreparedListener { mp -> mp.isLooping = true }
    }

    override fun settingPicker(){
        recommentedPicker.setItemTransformer(
            ScaleTransformer.Builder()
                .setMaxScale(1.2f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.CENTER) // CENTER is a default one
                .build()
        )

        recommentedPicker.addOnItemChangedListener(this)
        recommentedPicker.addScrollStateChangeListener(this)

        recommentedPicker.adapter = adapter
    }

    override fun onCurrentItemChanged(holder: MainRecommentViewHolder?, position: Int) {
        holder!!.show()
    }

    override fun onScroll(
        p0: Float,
        p1: Int,
        p2: Int,
        p3: MainRecommentViewHolder?,
        p4: MainRecommentViewHolder?
    ) {
    }

    override fun onScrollEnd(holder: MainRecommentViewHolder, p1: Int) {

    }

    override fun onScrollStart(holder: MainRecommentViewHolder, p1: Int) {
        holder!!.hide()
    }


}
