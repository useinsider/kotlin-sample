package  com.useinsider.insiderdemo

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.useinsider.insider.Insider

class InsiderFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.data.containsKey("source") && remoteMessage.data["source"] == "Insider") {
            Insider.Instance.handleFCMNotification(applicationContext, remoteMessage)
            return
        }
    }
}