package swam.atom.core.extensions

import android.content.Context
import android.util.TypedValue
import android.widget.Toast

/**
 * Created by stephen on 18-3-14.
 */

fun Context.toast(message: CharSequence) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.dpToPx(dp: Float): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()
