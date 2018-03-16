package swan.atom.core.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by stephen on 18-3-15.
 */
abstract class AtomCoreBaseFasterItemHolder<in T> constructor(
        itemView: View?
) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBindView(context: Context?, src: T?)
}