package com.jjmin.focus.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.jjmin.focus.R
import com.jjmin.focus.adapter.ListAdapter
import com.jjmin.focus.adapter.MainRecommentViewHolder
import com.jjmin.focus.model.ItemType
import com.jjmin.focus.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import kotlin.math.abs


class HomeFragment : BaseFragment() , HomeContract.View{

    override var initLayoutResourse: Int = R.layout.fragment_home

    lateinit var adapter : ListAdapter

    private val presenter : HomePresenter by inject{ parametersOf(this) }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    lateinit var animationVideo : LottieAnimationView
    lateinit var pagerPicker : ViewPager2
    lateinit var subRv : RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animationVideo = view.findViewById(R.id.animationVideo)
        pagerPicker = view.findViewById(R.id.pagerPicker)
        subRv = view.findViewById(R.id.subRecyclerview)

        adapter = ListAdapter()

        presenter.mainRecommentList.observe(this.activity!!, Observer {
            adapter.submitList(it)
        })

        presenter.loadUI()
    }

    override fun onResume() {
        super.onResume()
        startVideo()
    }

    fun startVideo() {
        animationVideo.setAnimation("main_recomment_anim.json")
        animationVideo.loop(true)
        animationVideo.playAnimation()
    }

    fun settingPicker(){
        adapter.setType(ItemType.MR)
        pagerPicker.adapter = adapter
        pagerPicker.getChildAt(0)

        pagerPicker.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        pagerPicker.offscreenPageLimit = 3
        pagerPicker.setPageTransformer(MarginPageTransformer(1500))
        pagerPicker.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val pageMargin =
            resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat()
        val pageOffset =
            resources.getDimensionPixelOffset(R.dimen.offset).toFloat()

        pagerPicker.currentItem

        pagerPicker.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            var beforePos = 0
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                var before_view = getViewHolder(beforePos)
                before_view.hide()

                var now_view = getViewHolder(position)
                now_view.show()

                beforePos = position
            }
        })

        pagerPicker.setPageTransformer { page, position ->
            val myOffset: Float = position * -(2 * pageOffset + pageMargin)
            when {

                position < -1 -> {
                    page.translationX = -myOffset
                }

                position <= 1 -> {
                    val scaleFactor =
                        0.4f.coerceAtLeast(1 - abs(position - 0.14285715f))
                    page.translationX = myOffset
                    var r = 1- abs(position)
                    page.scaleY = (((0.85 + r * 0.17f).toFloat()))
                    page.alpha = scaleFactor
                }

                else -> {
                    page.alpha = 0F
                    page.translationX = myOffset
                }
            }
        }
    }

    fun setSubRecyclerview(){
        subRv.layoutManager = LinearLayoutManager(context)
        adapter.setType(ItemType.SR)
        subRv.adapter = adapter
    }

    fun getViewHolder(position : Int) : MainRecommentViewHolder {
        return (pagerPicker[0] as RecyclerView).findViewHolderForAdapterPosition(position) as MainRecommentViewHolder
    }

    override fun loadUI() {
        startVideo()
        settingPicker()
    }
}
