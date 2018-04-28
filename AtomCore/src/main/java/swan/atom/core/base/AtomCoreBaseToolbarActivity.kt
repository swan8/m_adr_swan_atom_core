package swan.atom.core.base

import com.gyf.barlibrary.ImmersionBar
import swan.atom.core.R
import swan.atom.core.ui.Cirrus

/**
 * Created by stephen on 13/03/2018.
 */
open class AtomCoreBaseToolbarActivity: AtomCoreBaseActivity() {

    val builder: Cirrus.Companion.CirrusBuilder = Cirrus.Companion.CirrusBuilder()

    var cirrus: Cirrus? = null

    var AtomCoreBaseToolbarActivity.layoutResId
    get(): Int {
        return 0
    }
    set(value) {
        setContentView(value)
    }

    var AtomCoreBaseToolbarActivity.cirrusResId
    get(): Int {
        return 0
    }
    set(value) {
        cirrus = findViewById<Cirrus>(value)
    }

    var AtomCoreBaseToolbarActivity.immersionBar: ImmersionBar
    get(): ImmersionBar {
        return ImmersionBar
                .with(this)
                .fitsSystemWindows(true)
                .statusBarColor(R.color.colorPrimary)
                .statusBarDarkFont(false)
    }
    private set(value) {

    }
}