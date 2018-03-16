package swan.atom.core.basectx

import android.app.Application
import android.content.Context

/**
 * Created by stephen on 18-2-13.
 */
abstract class SwanAtomBaseApplication: Application() {

    interface SwanAtomApplicationImpl {

        fun onCreate(application: Application)

        fun getContext(): Context?
    }

    companion object {

        private val module: MutableList<String> = mutableListOf()
    }

    abstract fun initModuleApplicationImpl(module: MutableList<String>)

    override fun onCreate() {
        super.onCreate()

        initModuleApplicationImpl(module)

        initImpl()
    }

    private fun initImpl() {
        module.map {
            val clazz: Class<*>? = Class.forName(it)
            val newInstance: Any? = clazz?.newInstance()
            if (newInstance is SwanAtomApplicationImpl) {
                newInstance.onCreate(this)
            }
        }
    }
}