package swan.atom.core.base

import swan.atom.core.ui.Cirrus

/**
 * Created by stephen on 13/03/2018.
 */
open class AtomCoreBaseToolbarActivity: AtomCoreBaseActivity() {

    val builder: Cirrus.CirrusBuilder = Cirrus.CirrusBuilder()

    var cirrus: Cirrus? = null

    var AtomCoreBaseToolbarActivity.cirrusResId
    get(): Int {
        return 0
    }
    set(value) {
        cirrus = findViewById<Cirrus>(value)
    }
}