package swan.atom.core.rx

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by stephen on 24/04/2018.
 */
object AtomCoreBaseRxJavaTransformer {

    fun <T> all_main(): ObservableTransformer<T, T> {
        return ObservableTransformer<T, T> {
            upstream -> upstream.subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> io_main(): ObservableTransformer<T, T> {
        return ObservableTransformer<T, T> {
            upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }
}