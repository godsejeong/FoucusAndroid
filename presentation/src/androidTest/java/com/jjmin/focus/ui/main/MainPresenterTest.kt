package com.jjmin.focus.ui.main


import android.content.Context
import com.jjmin.focus.event.ThemeStatus
import com.jjmin.focus.event.TimeCheckEvent
import com.jjmin.focus.utils.SharedPreferencesUtil
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


class MainPresenterTest {

    private lateinit var view : MainContract.View

    private lateinit var context : Context

    private lateinit var sharedPreferencesUtil : SharedPreferencesUtil

    private lateinit var presenter : MainPresenter

    @Before
    fun setUp() {
        view = Mockito.mock(MainContract.View::class.java)
        context = Mockito.mock(Context::class.java)
        sharedPreferencesUtil = SharedPreferencesUtil(context)
        presenter = MainPresenter(view,TimeCheckEvent(),sharedPreferencesUtil)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun testNowStatus(){
        //day or night

        assertEquals(presenter.timeEvent.getThemeStatus(),ThemeStatus.Night)
    }

    @Test
    fun testgetRealHour(){
        assertEquals(presenter.timeEvent.getRealHour(),2)
    }

    @Test
    fun testGetAccessTime(){

    }
}