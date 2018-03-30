package swan.atom.core

import android.content.Context
import swan.atom.core.base.SwanAtomApplicationImpl
import java.lang.ref.WeakReference

/**
 * Created by stephen on 18-3-14.
 */
class AtomCoreApplicationImpl : SwanAtomApplicationImpl<AtomCoreApplicationImpl> {

    override var instance: AtomCoreApplicationImpl = this

    override lateinit var context: WeakReference<Context>
}