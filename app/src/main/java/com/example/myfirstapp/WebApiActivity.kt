package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.util.Log
import okhttp3.Call
import okhttp3.Request
import okhttp3.Response
import okhttp3.OkHttpClient
import okhttp3.Callback
import java.io.IOException

class WebApiActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_api)
    }

    fun onExecWebApiCall(view: View) {
        Log.i("WebApiActivity", "onExecWebApiCall()")

        var req = Request.Builder().url("https://api.publicapis.org/entries").build()
        var client = OkHttpClient.Builder().build()
        Log.i("WebApiActivity", "before api call")
        client.newCall(req).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                Log.i("WebApiActivity", "Failure")
            }
            override fun onResponse(call: Call, response: Response) {
                Log.i("WebApiActivity", response.body?.string().orEmpty())
            }
        })
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WebApiActivity> {
        override fun createFromParcel(parcel: Parcel): WebApiActivity {
            return WebApiActivity(parcel)
        }

        override fun newArray(size: Int): Array<WebApiActivity?> {
            return arrayOfNulls(size)
        }
    }
}