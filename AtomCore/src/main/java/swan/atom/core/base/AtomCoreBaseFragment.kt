package swan.atom.core.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.ajalt.timberkt.Timber
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by stephen on 13/03/2018.
 */
abstract class AtomCoreBaseFragment : Fragment(), View.OnClickListener {

    var hasVisibleToUser: AtomicBoolean = AtomicBoolean(false)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        hasVisibleToUser = AtomicBoolean(false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && ! hasVisibleToUser.get()) {
            hasVisibleToUser.getAndSet(true)
            fragmentOnFirstVisibleToUser()
        }
    }

    override fun onClick(v: View?) {

    }

    open fun fragmentOnFirstVisibleToUser() {
        Timber.e { "${this}::fragmentOnFirstVisibleToUser()::${hasVisibleToUser.get()}" }
    }
}