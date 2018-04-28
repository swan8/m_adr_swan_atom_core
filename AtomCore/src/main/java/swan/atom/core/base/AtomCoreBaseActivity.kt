package swan.atom.core.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by stephen on 13/03/2018.
 */
open class AtomCoreBaseActivity: AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onClick(v: View?) {

    }
}