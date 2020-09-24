package id.andiwijaya.fcmwithandroidbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val ACTION_ADD = "ACTION_ADD"
    }

    private var numberOfVisitor = 0

    private val addBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            numberOfVisitorTV.text = "${++numberOfVisitor}"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            Log.d("Device Token", it.token)
        }

        val addIntentFilter = IntentFilter(ACTION_ADD)
        registerReceiver(addBroadcastReceiver, addIntentFilter)

    }

    override fun onResume() {
        super.onResume()
        registerReceiver(addBroadcastReceiver, IntentFilter(ACTION_ADD))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(addBroadcastReceiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(addBroadcastReceiver)
    }

}