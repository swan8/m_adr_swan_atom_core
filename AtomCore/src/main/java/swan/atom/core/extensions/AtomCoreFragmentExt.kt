package swam.atom.core.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by stephen on 18-3-15.
 */
fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>) =
    activity?.application?.run {
         ViewModelProviders.of(activity!!, ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application!!)).get(viewModelClass)
    }
