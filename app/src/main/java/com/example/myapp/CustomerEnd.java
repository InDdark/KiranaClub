package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class CustomerEnd extends AppCompatActivity {
    EditText A2User,A2address,A2Email,A2LogID,A2pass;
    Button A2btn;
    Button Regbtn;
    DatabaseReference reff;
    customerData cusData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_end);
        //addListenerOnButton();
        Regbtn = (Button)findViewById(R.id.Regbtn);

       A2User = (EditText)findViewById(R.id.A2User);
       A2address = (EditText)findViewById(R.id.A2address);
       A2Email = (EditText)findViewById(R.id.A2Email);
       //A2DOB = (EditText)findViewById(R.id.A2DOB);
       A2LogID = (EditText)findViewById(R.id.A2LogID);
       A2pass = (EditText)findViewById(R.id.A2pass);
        cusData = new customerData();
      reff = FirebaseDatabase.getInstance().getReference().child("customerData");

        A2btn = (Button) findViewById(R.id.A2btn);
        A2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A2btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Intent intent = new Intent(arg0.getContext(), DashboardActivity.class);
                        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        String user = A2User.getText().toString().trim();
                        String address = A2address.getText().toString().trim();
                        String email   = A2Email.getText().toString().trim();
                        //Date birth = A2DOB.getText();
                        String UserID = A2LogID.getText().toString().trim();
                        String password = A2pass.getText().toString().trim();

                        cusData.setUserName(user);
                        cusData.setAddress(address);
                        cusData.setUserEmail(email);
                        cusData.setUserName(UserID);
                        cusData.setUserPass(password);

                        reff.push().setValue(cusData);
                        Toast.makeText(CustomerEnd.this,"database ran successfully",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

        // Write a message to the database

       A2btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openCusLog();
           }
       });



    }

    public void openCusLog(){
        Intent intent = new Intent(CustomerEnd.this,CusLog.class);
        startActivity(intent);
    }
}
