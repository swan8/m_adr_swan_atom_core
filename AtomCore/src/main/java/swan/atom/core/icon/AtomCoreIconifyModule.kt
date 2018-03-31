package swan.atom.core.icon

import com.joanzapata.iconify.Icon
import com.joanzapata.iconify.IconFontDescriptor

/**
 * Created by stephen on 18-3-30.
 */
object AtomCoreIconifyModule : IconFontDescriptor {

    override fun ttfFileName(): String {
        return "AtomCoreIconfont.ttf"
    }

    override fun characters(): Array<out Icon> {
        return AtomCoreIconifyIcons.values()
    }
}