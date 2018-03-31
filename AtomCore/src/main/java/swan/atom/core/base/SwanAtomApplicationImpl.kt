package swan.atom.core.base

import android.app.Application
import android.content.Context
import android.support.v4.content.ContextCompat
import java.lang.ref.WeakReference

/**
 * Created by stephen on 18-3-30.
 */
interface SwanAtomApplicationImpl {

    var reference: WeakReference<Context>

    fun onCreate(application: Application) {
        reference = WeakReference(application.applicationContext)
        applicationInit(application.applicationContext)
    }

    fun applicationInit(context: Context): Unit

    fun getContext(): Context? = reference.get()

    fun getColor(id: Int): Int = getContext()?.let { ContextCompat.getColor(it, id) } ?: android.R.color.transparent

    fun getString(resId: Int, vararg formatArgs: Any): String? = getContext()?.getString(resId, formatArgs)

    fun getDimens(id: Int): Int = getContext()?.resources?.getDimensionPixelOffset(id) ?: 0
}