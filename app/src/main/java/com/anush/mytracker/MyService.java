package com.anush.mytracker;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ANUSH on 26-02-2018.
 */

public class MyService extends IntentService {

    DatabaseReference databaseReference;

    public static boolean isRunning=false;

    public MyService() {
        super("MyService");
        isRunning=true;
        databaseReference= FirebaseDatabase.getInstance().getReference();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        databaseReference.child("Users").child(GlobalInfo.PhoneNumber).
                child("Updates").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Location location=TrackLocation.location;


                DateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:MM:ss");
                Date date=new Date();


                databaseReference.child("Users").child(GlobalInfo.PhoneNumber).child("Location").child("lat").setValue(TrackLocation.location.getLatitude());

                databaseReference.child("Users").child(GlobalInfo.PhoneNumber).child("Location").child("lag").setValue(TrackLocation.location.getLongitude());



                databaseReference.child("Users").child(GlobalInfo.PhoneNumber).
                        child("Location").child("lastSeenLocation").setValue(df.format(date).toString());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
