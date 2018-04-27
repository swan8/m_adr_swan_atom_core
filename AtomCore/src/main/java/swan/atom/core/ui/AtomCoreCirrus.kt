package swan.atom.core.ui

import android.graphics.drawable.Drawable
import android.support.annotation.IntegerRes

class AtomCoreCirrus {

    companion object {

        class AtomCoreCirrusBuilder constructor(
                cirrus: AtomCoreCirrus
        ) {

            private var navigationIcon: Drawable? = null

            fun withNavigationIcon(navigationIcon: Drawable): AtomCoreCirrusBuilder {
                this.navigationIcon = navigationIcon
                return this
            }

            fun withNavigationIconRes(@IntegerRes navigationIconRes: Int): AtomCoreCirrusBuilder {
//                this.navigationIcon = ContextCompat.getDrawable(AtomCoreApplicationImpl.getContext(), navigationIconRes);
                return this
            }

            fun withBackPressNavigationIcon(): AtomCoreCirrusBuilder {

                return this
            }

            private var titleMain: CharSequence? = null

            private var titleSub: CharSequence? = null

            private var titleCenter: CharSequence? = null

            fun withTitleMain(titleMain: CharSequence): AtomCoreCirrusBuilder {
                this.titleMain = titleMain
                return this
            }

            fun withTitleSub(titleSub: CharSequence): AtomCoreCirrusBuilder {
                this.titleSub = titleSub
                return this
            }

            fun withTitleCenter(titleCenter: CharSequence): AtomCoreCirrusBuilder {
                this.titleCenter = titleCenter
                return this
            }
        }
    }
}