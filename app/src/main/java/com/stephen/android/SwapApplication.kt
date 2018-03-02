package com.stephen.android

import swan.atom.core.basectx.SwanAtomBaseApplication

/**
 * Created by stephen on 02/03/2018.
 */
class SwapApplication : SwanAtomBaseApplication() {

    override fun initModuleApplicationImpl(module: MutableList<String>) {
        module.add("com.stephen.android.SwapApplicationImpl")
    }
}