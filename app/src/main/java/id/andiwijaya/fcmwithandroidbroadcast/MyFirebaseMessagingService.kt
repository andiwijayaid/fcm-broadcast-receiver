package id.andiwijaya.fcmwithandroidbroadcast

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        Log.d("NEW TOKEN", p0)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        when (remoteMessage.data["type"]) {
            "add" -> {
                val addServiceIntent = Intent(this, AddService::class.java)
                startService(addServiceIntent)
            }
        }
    }

}