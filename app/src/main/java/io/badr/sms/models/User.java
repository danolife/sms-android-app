package io.badr.sms.models;

import com.google.firebase.auth.FirebaseUser;

public class User {
    private String name;
    private String uid;
    private String email;
    private String phoneNumber;
    private String photoUrl;

    public User(FirebaseUser user) {
        this.name = user.getDisplayName();
        this.email = user.getEmail();
        this.uid = user.getUid();
        this.phoneNumber = user.getPhoneNumber();
        if (user.getPhotoUrl() != null) {
            this.photoUrl = user.getPhotoUrl().toString();
        }
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
