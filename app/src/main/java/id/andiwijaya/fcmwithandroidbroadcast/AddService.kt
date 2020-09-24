package id.andiwijaya.fcmwithandroidbroadcast

import android.content.Intent
import androidx.core.app.JobIntentService

class AddService : JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        val notifyFinishIntent = Intent(MainActivity.ACTION_ADD)
        sendBroadcast(notifyFinishIntent)
    }

}