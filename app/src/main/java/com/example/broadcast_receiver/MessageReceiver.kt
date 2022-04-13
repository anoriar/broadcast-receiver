package com.example.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MessageReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action) {
            "ru.broadcast_receiver.action.CAT" -> {
                Toast.makeText(context, "Обнаружено сообщение: ${intent.getStringExtra(MainActivity.ALARM_MESSAGE_CODE)}", Toast.LENGTH_LONG).show()
            }
            "android.intent.action.ACTION_POWER_DISCONNECTED" -> {
                val message = ("Обнаружено сообщение "
                        + intent.action)
                Toast.makeText(
                    context, message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}