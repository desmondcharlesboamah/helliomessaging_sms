package com.helliomessaging.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.helliomessaging.sms.sendSMS
import kotlinx.android.synthetic.main.activity_main.*

@SuppressLint("NonConstantResourceId")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_continue?.setOnClickListener {
            sendMessage()
        }
    }

    fun sendMessage(){
        if(verifyAvailableNetwork()) {
            if (client_id?.text?.isNotEmpty()!! && applicationSecret?.text?.isNotEmpty()!! && phone_number?.text?.isNotEmpty()!! && message?.text?.isNotEmpty()!!) {
                btn_continue?.apply {
                    text = getString(R.string.sending)
                    sendSMS(
                        phone_number?.text?.toString()!!, client_id?.text?.toString()!!,
                        applicationSecret!!.text!!.toString(), sender_id?.text?.toString()!!,
                        message?.text?.toString()!!
                    ) { response, message ->
                        response_message?.text = message
                        this.text = getString(R.string.send_sms)
                    }
                }

            } else {
                toast(R.string.all_fields_required)
            }
        }else{
            toast(R.string.no_network)
        }

    }
}