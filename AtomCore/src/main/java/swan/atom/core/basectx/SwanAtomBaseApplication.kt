package swan.atom.core.basectx

import android.app.Application

/**
 * Created by stephen on 18-2-13.
 */
open class SwanAtomBaseApplication: Application() {

    companion object {

        val module: Array<String> = arrayOf(
                "swan.biz.soccer.SwanSoccerApplicationImpl"
        )
    }

    override fun onCreate() {
        super.onCreate()
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