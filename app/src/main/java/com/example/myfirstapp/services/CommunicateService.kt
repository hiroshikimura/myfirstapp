package com.example.myfirstapp.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Parcel
import android.os.Parcelable

class CommunicateService() : Service(), Parcelable {
    //private val binder = MyBinder()

    constructor(parcel: Parcel) : this() {
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null //binder
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CommunicateService> {
        override fun createFromParcel(parcel: Parcel): CommunicateService {
            return CommunicateService(parcel)
        }

        override fun newArray(size: Int): Array<CommunicateService?> {
            return arrayOfNulls(size)
        }
    }
}
