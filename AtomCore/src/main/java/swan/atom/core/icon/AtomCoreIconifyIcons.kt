package swan.atom.core.icon

import com.joanzapata.iconify.Icon
import swan.atom.core.constants.ISymbol

/**
 * Created by stephen on 18-3-30.
 */
enum class AtomCoreIconifyIcons constructor(character: Char) : Icon {

    ATOM_CORE_BACK('\ue697'),

    ATOM_CORE_CATEGORY('\ue699'),

    ATOM_CORE_VIEW_CATEGORY('\ue6b4'),

    ATOM_CORE_SHARE('\ue71d'),

    ATOM_CORE_DOWNLOAD('\ue714'),

    ATOM_CORE_FAVORITE_HEART('\ue7ce'),

    ATOM_CORE_CLOCK('\ue6bb'),

    ATOM_CORE_DIAMOND('\ue735'),

    ATOM_CORE_SHOE('\ue728'),

    ATOM_CORE_TOY('\ue6e1'),

    ATOM_CORE_SETTING('\ue6ae'),

    ATOM_CORE_INFORMATION('\ue6a4'),

    ATOM_CORE_EARTH('\ue828'),

    ;

    var character: Char = 0.toChar()

    init {
        this.character = character
    }

    override fun key(): String {
        return name
    }

    override fun character(): Char {
        return character
    }

    fun value(): String = value(prefix = ISymbol.EMPTY, conf = ISymbol.EMPTY, suffix = ISymbol.EMPTY)

    fun value(suffix: String): String = value(prefix = ISymbol.EMPTY, conf = ISymbol.EMPTY, suffix = suffix)

    fun value(prefix: String, suffix: String, conf: String) = String.format("%s{%s%s}%s", prefix, key(), conf, suffix)
}