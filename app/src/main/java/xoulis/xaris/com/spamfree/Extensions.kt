package xoulis.xaris.com.spamfree

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.design.widget.Snackbar
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

/* Views */
fun View.enableView(enable: Boolean) {
    isEnabled = enable
    isClickable = enable
    alpha = if (enable) 1.0f else 0.5f
}

fun View.showSnackBar(messageResId: Int, shortDuration: Boolean = true) {
    val duration = if (shortDuration) Snackbar.LENGTH_SHORT else Snackbar.LENGTH_LONG
    Snackbar.make(this, messageResId, duration).show()
}

/* Network */
fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}