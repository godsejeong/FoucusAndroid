package com.jjmin.focus.ui.home

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.jjmin.focus.R
import com.jjmin.focus.adapter.ListAdapter
import com.jjmin.focus.adapter.MainRecommentViewHolder
import com.jjmin.focus.model.ItemType
import com.jjmin.focus.ui.base.BaseFragment
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
class HomeFragment : BaseFragment() , HomeContract.View,
    DiscreteScrollView.OnItemChangedListener<MainRecommentViewHolder>,
    DiscreteScrollView.ScrollStateChangeListener<MainRecommentViewHolder>{
    override var initLayoutResourse: Int = R.layout.fragment_home

    lateinit var adapter : ListAdapter

    private val presenter : HomePresenter by inject{ parametersOf(this) }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    lateinit var animationVideo : LottieAnimationView
    lateinit var recommentedPicker : DiscreteScrollView
    lateinit var testRv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animationVideo = view.findViewById(R.id.animationVideo) as LottieAnimationView
        recommentedPicker = view.findViewById(R.id.recommentedPicker) as DiscreteScrollView
        testRv = view.findViewById(R.id.testRv) as RecyclerView


        adapter = ListAdapter()
        adapter.setType(ItemType.MR)

        presenter.dummyList.observe(this.activity!!, Observer {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
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


        recommentedPicker.setItemTransformer(
            ScaleTransformer.Builder()
                .setMaxScale(1.2f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.CENTER) // CENTER is a default one
                .build()
        )
        recommentedPicker.setSlideOnFling(true)
        recommentedPicker.addOnItemChangedListener(this)
        recommentedPicker.addScrollStateChangeListener(this)
        recommentedPicker.scrollToPosition(2)

        presenter.init()

        recommentedPicker.adapter = adapter


//        var manager = LinearLayoutManager(activity!!.baseContext)
//        testRv.layoutManager = manager
//        testRv.adapter = adapter
    }

    override fun onCurrentItemChanged(holder: MainRecommentViewHolder?, position: Int) {
        if (holder != null) {
            holder!!.show()
        }
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
        holder.hide()
    }

    override fun loadUI() {
        startVideo()
        settingPicker()
    }
}
