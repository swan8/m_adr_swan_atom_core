package swan.atom.core.base

import android.support.v7.app.AppCompatActivity
import android.view.View
import com.gyf.barlibrary.ImmersionBar
import swan.atom.core.R

/**
 * Created by stephen on 13/03/2018.
 */
open class AtomCoreBaseActivity: AppCompatActivity(), View.OnClickListener {

    var AtomCoreBaseActivity.layoutResId
    get(): Int {
        return 0
    }
    set(value) {
        setContentView(value)
    }

    var AtomCoreBaseActivity.immersionBar: ImmersionBar
    get(): ImmersionBar {
        return ImmersionBar
                .with(this)
                .fitsSystemWindows(true)
                .statusBarColor(R.color.colorPrimary)
                .statusBarDarkFont(false)
    }
    private set(value) {

    }

    override fun onClick(v: View?) {

    }
}