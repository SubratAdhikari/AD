package com.example.dapp;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DboUserInfo {
    public DatabaseReference databaseReference, databaseReference2;

    public DatabaseReference gpsCReference;

    public DboUserInfo() {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("UserInfo");

        databaseReference2 = db.getReference();

        gpsCReference = db.getReference("GioLocations");


    }

    public Task<Void> adduinfo(UserInfo uinfo, String uid)
    {
        return databaseReference.child(uid).setValue(uinfo);
    }

    public Task<Void> setonoffduty(String uid,String onoffduty)
    {
        return databaseReference.child(uid).child("onoffduty").setValue(onoffduty);
    }

    public Task<Void> uploadtime(String uid,String time)
    {
        return databaseReference.child(uid).child("lastOnlineAt").setValue(time);
    }


}
