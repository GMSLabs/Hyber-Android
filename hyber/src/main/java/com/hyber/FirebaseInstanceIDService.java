package com.hyber;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "FirebaseIIDService";

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Hyber.Log(Hyber.LOG_LEVEL.DEBUG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer();
    }
    // [END refresh_token]

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     */
    private void sendRegistrationToServer() {
        MainApiBusinessModel.getInstance(this)
                .sendDeviceData(new MainApiBusinessModel.SendDeviceDataListener() {
                    @Override
                    public void onSent() {
                        Hyber.Log(Hyber.LOG_LEVEL.DEBUG, "Refreshed token is sent.");
                    }

                    @Override
                    public void onSendingError(SendDeviceDataErrorStatus status) {
                        Hyber.Log(Hyber.LOG_LEVEL.WARN, status.getDescription());
                    }
                });
    }

}
