package swan.atom.core.base

import android.app.Application
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.isSubclassOf

/**
 * Created by stephen on 18-2-13.
 */
abstract class SwanAtomBaseApplication: Application() {

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
            try {
                val clazz: Class<*>? = Class.forName(it)
                clazz?.kotlin?.isSubclassOf(SwanAtomApplicationImpl::class).run {
                    if (null == clazz?.kotlin?.objectInstance) {
                        val newInstance: SwanAtomApplicationImpl = clazz?.kotlin?.createInstance() as SwanAtomApplicationImpl
                        newInstance.onCreate(this@SwanAtomBaseApplication)
                    } else {
                        clazz.fields?.findLast { it.name == "INSTANCE" }?.let {
                            val anyObject: Any = it.get(clazz)
                            if (anyObject is SwanAtomApplicationImpl) {
                                anyObject.onCreate(this@SwanAtomBaseApplication)
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}