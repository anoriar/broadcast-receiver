package com.example.broadcast_receiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnSendMessage: Button

    private var timeBroadcastReceiver: TimeBroadcastReceiver = TimeBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSendMessage = findViewById(R.id.button_send_message)
        btnSendMessage.setOnClickListener {
            sendMessage()
        }

    }

    override fun onResume() {
        super.onResume()
        registerReceiver(timeBroadcastReceiver, IntentFilter("android.intent.action.TIME_TICK"))
        Toast.makeText(
            applicationContext, "Приёмник включен",
            Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(
            applicationContext, "Приёмник выключен",
            Toast.LENGTH_SHORT).show()
    }

    private fun sendMessage(){
        val intent = Intent(WHERE_MY_CAT_ACTION).apply {
            putExtra(ALARM_MESSAGE_CODE,  applicationContext.getString(R.string.alarm_message))
        }
        sendBroadcast(intent)
    }

    companion object {
        const val WHERE_MY_CAT_ACTION = "ru.broadcast_receiver.action.CAT"
        const val ALARM_MESSAGE_CODE = "ru.broadcast_receiver.message"
    }
}