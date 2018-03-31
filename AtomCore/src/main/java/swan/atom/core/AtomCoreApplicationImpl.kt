package swan.atom.core

import android.content.Context
import com.github.ajalt.timberkt.Timber
import com.joanzapata.iconify.Iconify
import swan.atom.core.base.SwanAtomApplicationImpl
import swan.atom.core.icon.AtomCoreIconifyModule
import java.lang.ref.WeakReference

/**
 * Created by stephen on 18-3-14.
 */
object AtomCoreApplicationImpl : SwanAtomApplicationImpl {

    override lateinit var reference: WeakReference<Context>

    override fun applicationInit(context: Context) {
        Timber.plant(Timber.DebugTree())
        Iconify.with(AtomCoreIconifyModule)
    }
}