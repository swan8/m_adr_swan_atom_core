package swan.atom.core.injector

import android.app.Activity
import android.app.Dialog
import android.support.v4.app.Fragment
import android.view.View
import java.lang.reflect.Field
import java.util.*

class Injector constructor(
        container: Any,
        parent: Any,
        ignore: Boolean)
{

    companion object {

        const val EVAL_ERROR = "eval error"

        const val VIEW_NOT_FOUND = "view not found"

        val HALT_CLASSES  = arrayOf(
                Activity::class.java,
                Fragment::class.java,
                View::class.java,
                Any::class.java,
                Dialog::class.java
        )

        fun inject(container: Any): Injector {
            return Injector(container, container, false)
        }

        fun inject(container: Any, ignore: Boolean): Injector {
            return Injector(container, container, ignore)
        }

        fun inject(container: Any, parent: Any): Injector {
            return Injector(container, parent, false)
        }
    }

    init {
        val clazz: Class<*> = container.javaClass
        if (Injector.HALT_CLASSES.contains(clazz)) {
            val fields = clazz.declaredFields
            for (field in fields) {
                if (field.isAnnotationPresent(From::class.java)) {
                    val from = field.getAnnotation(From::class.java)
                    val id = from.value
                    field.isAccessible = true
                    val view = inflateView(parent, id)
                    if (! ignore && ! from.canBeNull && view == null) {
                        throwInjectorException(field, VIEW_NOT_FOUND, id)
                    } else if (view != null) {
                        try {
                            field.set(container, view)
                        } catch (e: Exception) {
                            throwInjectorException(field, EVAL_ERROR, id)
                        }
                    }
                }
            }
        }
    }

    private fun throwInjectorException(field: Field, info: String, vararg ids: Int) {
        val message: String = "field ${field.toGenericString()} = [ ${Arrays.toString(ids)} ] not injected! Check your field or layout xml id value! [$info]"
        throw InjectorException(message)
    }


    private fun inflateView(parent: Any, id: Int): View? {
        return when (parent) {
            is Activity -> parent.findViewById<View>(id)
            is Fragment -> parent.view?.findViewById<View>(id)
            is View -> parent.findViewById<View>(id)
            is Dialog -> parent.findViewById<View>(id)
            else -> null
        }
    }
}