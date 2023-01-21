package com.rafiansyahdesign.ripcordmessenger.Notifications;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseIdService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        updateToken(token);

    }

    private void updateToken(String refreshToken)
    {
        FirebaseUser firebaseUser =FirebaseAuth.getInstance().getCurrentUser();
        Token token=new Token(refreshToken);
        FirebaseDatabase.getInstance().getReference("Tokens")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(token);
    }

}
