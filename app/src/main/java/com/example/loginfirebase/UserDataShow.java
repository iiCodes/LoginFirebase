package com.example.loginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserDataShow extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference userData;
    Adapter myadapter;
    ArrayList<userdata> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_show);

        recyclerView=findViewById(R.id.userlist);
        userData= FirebaseDatabase.getInstance().getReference().child("UserData");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list=new ArrayList<>();
        myadapter=new Adapter(this,list);
        recyclerView.setAdapter(myadapter);

        userData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    userdata data=dataSnapshot.getValue(userdata.class);
                    list.add(data);
                }
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}