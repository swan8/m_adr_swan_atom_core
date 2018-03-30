package swan.atom.core.base

import android.app.Application
import android.content.Context
import java.lang.ref.WeakReference

/**
 * Created by stephen on 18-3-30.
 */
interface SwanAtomApplicationImpl<T : SwanAtomApplicationImpl<T>> {

    var instance: T

    var context: WeakReference<Context>

    fun onCreate(application: Application) {
        context = WeakReference(application.applicationContext)
    }

    fun getContext(): Context? = context.get()

    fun getColor(id: Int): Int = getContext()?.resources?.getColor(id) ?: 0

    fun getString(resId: Int, vararg formatArgs: Any): String? = getContext()?.getString(resId, formatArgs)

    fun getDimens(id: Int): Int = getContext()?.resources?.getDimensionPixelOffset(id) ?: 0
}