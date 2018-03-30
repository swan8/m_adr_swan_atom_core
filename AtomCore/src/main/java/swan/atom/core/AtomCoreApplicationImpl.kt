package swan.atom.core

import android.app.Application
import android.content.Context
import swan.atom.core.base.SwanAtomApplicationImpl
import java.lang.ref.WeakReference

/**
 * Created by stephen on 18-3-14.
 */
object AtomCoreApplicationImpl : SwanAtomApplicationImpl {

    override lateinit var reference: WeakReference<Context>

    override fun onCreate(application: Application) {
        super.onCreate(application)
        println("${this}::reference::${this.reference}")
    }
}