package id.andiwijaya.fcmwithandroidbroadcast

import android.content.Context
import android.content.Intent
import androidx.core.app.JobIntentService

class AddService : JobIntentService() {

    companion object {
        fun enqueueWork(context: Context, intent: Intent) {
            enqueueWork(context, AddService::class.java, 123, intent)
        }
    }

    override fun onHandleWork(intent: Intent) {
        val notifyFinishIntent = Intent(MainActivity.ACTION_ADD)
        sendBroadcast(notifyFinishIntent)
    }

}