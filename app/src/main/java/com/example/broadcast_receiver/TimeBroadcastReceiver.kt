package com.example.broadcast_receiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.text.Format
import java.text.SimpleDateFormat
import java.util.*

class TimeBroadcastReceiver : BroadcastReceiver() {

    @SuppressLint("SimpleDateFormat")

    override fun onReceive(context: Context, intent: Intent) {
        val dateFormatter: Format = SimpleDateFormat("hh:mm:ss a")
        Toast.makeText(context, "текущее время: ${dateFormatter.format(Date())}", Toast.LENGTH_SHORT).show()
    }
}