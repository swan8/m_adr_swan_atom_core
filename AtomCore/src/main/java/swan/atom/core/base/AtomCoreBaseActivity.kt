package swan.atom.core.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by stephen on 13/03/2018.
 */
open class AtomCoreBaseActivity: AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onClick(v: View?) {

    }
}