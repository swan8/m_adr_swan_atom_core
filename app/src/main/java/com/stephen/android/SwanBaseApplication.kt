package com.stephen.android

import swan.atom.core.basectx.SwanAtomBaseApplication

/**
 * Created by stephen on 02/03/2018.
 */
class SwanBaseApplication : SwanAtomBaseApplication() {

    override fun initModuleApplicationImpl(module: MutableList<String>) {
        module.add("swan.atom.core.AtomCoreApplicationImpl")
    }
}