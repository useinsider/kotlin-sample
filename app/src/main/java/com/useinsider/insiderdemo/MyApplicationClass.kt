package com.useinsider.insiderdemo

import android.app.Application
import android.util.Log
import com.useinsider.insider.Insider
import com.useinsider.insider.InsiderCallbackType


class MyApplicationClass : Application() {
    @Override
    override fun onCreate() {
        super.onCreate()

        // TODO: Please change with your partner name. You can find the partner name after login
        //  into the Insider panel. The left side of your mail address.
        Insider.Instance.init(this, "your_partner_name")
        Insider.Instance.registerInsiderCallback { data, callbackType ->
            when (callbackType) {
                InsiderCallbackType.NOTIFICATION_OPEN -> Log.d(
                    "[INSIDER]",
                    "[NOTIFICATION_OPEN]: $data"
                )
                InsiderCallbackType.TEMP_STORE_PURCHASE -> Log.d(
                    "[INSIDER]",
                    "[TEMP_STORE_PURCHASE]: $data"
                )
                InsiderCallbackType.TEMP_STORE_ADDED_TO_CART -> Log.d(
                    "[INSIDER]",
                    "[TEMP_STORE_ADDED_TO_CART]: $data"
                )
                InsiderCallbackType.TEMP_STORE_CUSTOM_ACTION -> Log.d(
                    "[INSIDER]",
                    "[TEMP_STORE_CUSTOM_ACTION]: $data"
                )
            }
        }
        // TODO: Add your splash activity.
        // Insider.Instance.setSplashActivity(Splash.activity)
        Insider.Instance.startTrackingGeofence()
        Insider.Instance.enableIDFACollection(false)
        Insider.Instance.getCurrentUser().setLocale("tr_TR")
    }
}