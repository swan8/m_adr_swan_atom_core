package swan.atom.core.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.StringRes
import android.support.v7.view.menu.MenuBuilder
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.joanzapata.iconify.widget.IconTextView
import swan.atom.core.AtomCoreApplicationImpl
import swan.atom.core.R
import java.lang.ref.WeakReference

class Cirrus(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    companion object {

        class CirrusBuilder {

            fun build(cirrus: Cirrus?): CirrusBuilder {
                return cirrus?.let {
                    it.build(this)
                    this
                } ?: this
            }

            /**
             * Toolbar的导航图标
             *
             * @see Toolbar.setNavigationIcon
             */
            internal var cirrusNavigationIconDrawable: Drawable? = null

            /**
             * Toolbar的居中标题
             *
             * @see Cirrus.cirrusCenterText
             */
            internal var cirrusCenterTitleSequence: CharSequence? = null

            /**
             * Toolbar的主标题
             *
             * @see Toolbar.mTitleText
             */
            internal var cirrusTitleSequence: CharSequence? = null

            /**
             * Toolbar的副标题
             *
             * @see Toolbar.mSubtitleText
             */
            internal var cirrusSubtitleSequence: CharSequence? = null

            /**
             * Toolar右侧按钮（右1）
             *
             * @see Cirrus.cirrusRightComponent1
             */
            internal var rightComponent1Sequence: CharSequence? = null

            /**
             * Toobar右侧按钮（右2）
             *
             * @see Cirrus.cirrusRightComponent2
             */
            internal var rightComponent2Sequence: CharSequence? = null

            internal var cirrusMenu: Int? = null

            internal var cirrusMenuItemClickListener: WeakReference<Toolbar.OnMenuItemClickListener>? = null

            fun withCirrusNavigationIcon(resId: Int?): CirrusBuilder {
                return resId?.let {
                    withCirrusNavigationIcon(AtomCoreApplicationImpl.getDrawable(it))
                } ?: this
            }

            fun withCirrusNavigationBackPressIcon(): CirrusBuilder {
                return withCirrusNavigationIcon(AtomCoreApplicationImpl.getDrawable(R.drawable.cirrus_ic_back_white_64dp))
            }

            fun withCirrusNavigationCloseIcon(): CirrusBuilder {
                return withCirrusNavigationIcon(AtomCoreApplicationImpl.getDrawable(R.drawable.cirrus_ic_close_white_64dp))
            }

            fun withCirrusNavigationIcon(drawable: Drawable?): CirrusBuilder {
                return drawable?.let {
                    cirrusNavigationIconDrawable = it
                    this
                } ?: this
            }

            fun withCirrusCenterTitle(@StringRes resId: Int?, vararg formatArgs: Any): CirrusBuilder {
                return resId?.let {
                    withCirrusCenterTitle(AtomCoreApplicationImpl.getString(resId, formatArgs))
                } ?: this
            }

            fun withCirrusCenterTitle(title: CharSequence?): CirrusBuilder {
                return title?.let {
                    cirrusCenterTitleSequence = title
                    this
                } ?: this
            }

            fun withCirrusTitle(@StringRes resId: Int?, vararg formatArgs: Any): CirrusBuilder {
                return resId?.let {
                    withCirrusTitle(AtomCoreApplicationImpl.getString(it, formatArgs))
                } ?: this
            }

            fun withCirrusTitle(title: CharSequence?): CirrusBuilder {
                return title?.let {
                    cirrusTitleSequence = title
                    this
                } ?: this
            }

            fun withCirrusSubtitle(@StringRes resId: Int?, vararg formatArgs: Any): CirrusBuilder {
                return resId?.let {
                    withCirrusSubtitle(AtomCoreApplicationImpl.getString(it, formatArgs))
                } ?: this
            }

            fun withCirrusSubtitle(title: CharSequence?): CirrusBuilder {
                return title?.let {
                    cirrusSubtitleSequence = title
                    this
                } ?: this
            }

            fun withCirrusRightComponent(@StringRes resId1: Int?, @StringRes resId2: Int?): CirrusBuilder {
                return resId1?.let {
                    resId2?.let {
                        withCirrusRightComponent(AtomCoreApplicationImpl.getString(resId1), AtomCoreApplicationImpl.getString(it))
                    } ?: withCirrusRightComponent(AtomCoreApplicationImpl.getString(it), null)
                } ?: resId2?.let {
                    withCirrusRightComponent(null, AtomCoreApplicationImpl.getString(it))
                } ?: this
            }

            fun withCirrusRightComponent(component1: CharSequence?, component2: CharSequence?): CirrusBuilder {
                rightComponent1Sequence = component1
                rightComponent2Sequence = component2
                return this
            }

            fun withCirrusMenu(resId: Int?, listener: Toolbar.OnMenuItemClickListener?): CirrusBuilder {
                cirrusMenu = resId;
                this.cirrusMenuItemClickListener = WeakReference<Toolbar.OnMenuItemClickListener>(listener)
                return this
            }
        }
    }

    internal var cirrusToolbar: Toolbar? = null

    internal var cirrusCenterText: TextView? = null

    internal var cirrusRightComponent1: IconTextView? = null

    internal var cirrusRightComponent2: IconTextView? = null

    fun getToolbar(): Toolbar? {
        return this.cirrusToolbar
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        cirrusToolbar = findViewById<Toolbar>(R.id.cirrusToolbar)
        cirrusCenterText = findViewById<TextView>(R.id.cirrusCenterTitleView)
        cirrusRightComponent1 = findViewById<IconTextView>(R.id.cirrusRightComponent1)
        cirrusRightComponent2 = findViewById<IconTextView>(R.id.cirrusRightComponent2)
    }

    internal fun build(builder: CirrusBuilder?): Cirrus {
        return builder?.let {
            layoutCirrusNavigationIcon(it)
                    .layoutCirrusTitle(it)
                    .layoutCirrusRightComponent(it)
                    .layoutCirrusMenu(it)
        } ?: this
    }

    private fun layoutCirrusNavigationIcon(builder: CirrusBuilder): Cirrus {
        return cirrusToolbar?.let {
            it.navigationIcon = builder.cirrusNavigationIconDrawable
            this
        } ?: this
    }

    private fun layoutCirrusTitle(builder: CirrusBuilder): Cirrus {
        builder.cirrusCenterTitleSequence?.let {
            cirrusCenterText?.let {
                it.text = builder.cirrusCenterTitleSequence
                it.visibility = View.VISIBLE
            }

            cirrusToolbar?.let {
                it.title = null
                it.subtitle = null
            }

            return this
        } ?: cirrusCenterText?.let {
            it.text = null
            it.visibility = View.GONE
        }

        return builder.cirrusTitleSequence?.let {
            cirrusToolbar?.let {
                it.title = builder.cirrusTitleSequence
                it.subtitle = builder.cirrusSubtitleSequence
            }

            this
        } ?: this
    }

    private fun layoutCirrusRightComponent(builder: CirrusBuilder): Cirrus {
        builder.rightComponent1Sequence?.let {
            cirrusRightComponent1?.let {
                it.text = builder.rightComponent1Sequence
                it.visibility = View.VISIBLE
            }
        } ?: cirrusRightComponent1?.let {
            it.text = null
            it.visibility = View.GONE
        }

        builder.rightComponent2Sequence?.let {
            cirrusRightComponent2?.let {
                it.text = builder.rightComponent2Sequence
                it.visibility = View.VISIBLE
            }
        } ?: cirrusRightComponent2?.let {
            it.text = null
            it.visibility = View.GONE
        }

        return this
    }

    private fun layoutCirrusMenu(builder: CirrusBuilder): Cirrus {
        return cirrusToolbar?.let { cirrusToolbar ->
            builder.cirrusMenu?.let {
                cirrusToolbar.inflateMenu(it)
                cirrusToolbar.menu?.let { menu ->
                    if (menu is MenuBuilder) {
//                        menu.setOptionalIconsVisible(true)
                    }
                }
            }

            builder.cirrusMenuItemClickListener?.let {
                cirrusToolbar.setOnMenuItemClickListener(it.get())
            }

            this
        } ?: this
    }
}