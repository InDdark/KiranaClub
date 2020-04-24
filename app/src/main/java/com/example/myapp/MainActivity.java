package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
     private Button button;
     Button testBtn;
     EditText testName;
     FirebaseDatabase database;
     DatabaseReference reef;
     testUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toast.makeText(context; MainActivity.this,text;"Success",Toast.LENGTH_LONG).show();
        button = findViewById(R.id.Regbtn);
        testBtn = findViewById(R.id.testBtn);
        testName = (EditText)findViewById(R.id.testName);
        database = FirebaseDatabase.getInstance();
        reef = database.getReference("Kiranaclub-49c8d");
        user = new testUser();



        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       user.setTestName(testName.getText().toString());
                       reef.setValue("User01");
                       Toast.makeText(MainActivity.this,"Bammm",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                });





            }
        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openCustomerEnd();
            }
        });
    }
    public void openCustomerEnd(){
         Intent intent = new Intent(MainActivity.this,CustomerEnd.class);
          startActivity(intent);
    }

}
