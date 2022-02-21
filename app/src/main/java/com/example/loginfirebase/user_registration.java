package com.example.loginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class user_registration extends AppCompatActivity {

    EditText name,password,email;
    Button signup,back;
    DatabaseReference userData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        userData= FirebaseDatabase.getInstance().getReference().child("userData");
        UI();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendUserData();
            }
        });

    }

    private void sendUserData(){
              String n,p,e;
              n=name.getText().toString();
              p=password.getText().toString();
              e=email.getText().toString();
              userdata data=new userdata(n,p,e);

              userData.push().setValue(data);
        Toast.makeText(this,"Registration Successful",Toast.LENGTH_SHORT).show();


    }
    private void UI(){
        name=findViewById(R.id.Name);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);

        signup=findViewById(R.id.signup);
        back=findViewById(R.id.back);
    }
}