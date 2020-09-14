package com.jjmin.focus.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jjmin.focus.R
import com.jjmin.focus.SearchFragment
import com.jjmin.focus.ui.base.BaseActivity
import com.jjmin.focus.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity()
{
    override var initLayoutResourse: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingView(main)
        initView()
    }
    private val fragmentMap = mutableMapOf<Int,Fragment>()

    private fun initView() {
        fragmentMap[R.id.nav_home] = HomeFragment.newInstance()
        fragmentMap[R.id.nav_search] = SearchFragment.newInstance()
        fragmentMap[R.id.nav_detail] = SearchFragment.newInstance()
        fragmentMap[R.id.nav_mypage] = SearchFragment.newInstance()

        mainBottomNavigation.setOnNavigationItemSelectedListener {
            fragmentMap[it.itemId]?.let { fragment ->
                replaceFragment(fragment)
                true
            } ?: false
        }
        mainBottomNavigation.selectedItemId = R.id.nav_home
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .commitNowAllowingStateLoss()
    }
}
