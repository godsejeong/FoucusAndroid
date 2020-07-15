package com.jjmin.focus.di

import com.jjmin.focus.event.TimeCheckEvent
import org.koin.dsl.module

val timeModule = module {
    factory { TimeCheckEvent() }
}

