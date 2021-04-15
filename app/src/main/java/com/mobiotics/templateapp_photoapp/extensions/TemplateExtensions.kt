package com.mobiotics.templateapp_photoapp.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build

@Suppress("DEPRECATION")
fun Context?.isOnline(): Boolean {
    val connectivityManager = this?.getSystemService(
        Context.CONNECTIVITY_SERVICE
    ) as ConnectivityManager
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val networks = connectivityManager.allNetworks
        var hasInternet = false
        if (networks.isNotEmpty()) {
            networks.forEach { network ->
                val nc = connectivityManager.getNetworkCapabilities(network)
                if (nc!!.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) hasInternet =
                    true
            }
        }
        hasInternet
    } else {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        activeNetwork?.isConnectedOrConnecting == true
    }
}
