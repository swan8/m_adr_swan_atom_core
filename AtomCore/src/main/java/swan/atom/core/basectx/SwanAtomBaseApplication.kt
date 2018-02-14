package swan.atom.core.basectx

import android.app.Application

/**
 * Created by stephen on 18-2-13.
 */
class SwanAtomBaseApplication: Application() {

    companion object {

        val module: Array<String> = arrayOf(
                "swam.biz.soccer.SwanSoccerApplicationImpl"
        )
    }

    override fun onCreate() {
        super.onCreate()
        initImpl()
    }

    private fun initImpl() {
        for (i in module.indices) {
            var clazz: Class<*>? = Class.forName(module[i])
            val newInstance: Any? = clazz?.newInstance()
            if (newInstance is SwanAtomApplicationImpl) {
                newInstance.onCreate(this)
            }
        }
    }
}