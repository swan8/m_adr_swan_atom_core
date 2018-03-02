package com.stephen.android

import android.app.Application
import android.content.Context
import swan.atom.core.basectx.SwanAtomApplicationImpl
import java.lang.ref.WeakReference

/**
 * Created by stephen on 02/03/2018.
 */
class SwapApplicationImpl: SwanAtomApplicationImpl {

    companion object {
        lateinit var instance: SwapApplicationImpl
        private set
    }

    private var context: WeakReference<Context>? = null

    override fun onCreate(application: Application) {
        instance = this
        instance.context = WeakReference(application.applicationContext)
    }

    override fun getContext(): Context? {
        context?.get()?.let {
            return it
        }

        return null
    }
}