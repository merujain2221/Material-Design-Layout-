package com.example.materialdesigndashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class call_Activity extends AppCompatActivity {

    EditText editText;
    Button button;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_);
        editText= (EditText)findViewById(R.id.editText);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomAppBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                case R.id.action_recent:
                    Toast.makeText(call_Activity.this, "Recent Button Clicked!", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.action_place:
                        Toast.makeText(call_Activity.this, "Place Button Clicked!", Toast.LENGTH_SHORT).show();
                        break;
                        case R.id.action_fav:
                        Toast.makeText(call_Activity.this, "Favourite Button Clicked!", Toast.LENGTH_SHORT).show();
                        break;




                }return true;

            }
        });

        button= (Button)findViewById(R.id.callButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itenCall = new Intent(Intent.ACTION_CALL);
                String number = editText.getText().toString();
                if (number.trim().isEmpty()) {
                    Toast.makeText(call_Activity.this, "Plz Enter Phone Number", Toast.LENGTH_SHORT).show();
                }
                else {
                    itenCall.setData(Uri.parse("tel:"+number));

                }
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(call_Activity.this, "Plz Grant Permission", Toast.LENGTH_SHORT).show();
                    requestionPermission();

                }else {
                    startActivity(itenCall);
                }



            }
        });
    }
    private void requestionPermission() {
        ActivityCompat.requestPermissions(call_Activity.this,new String[]{Manifest.permission.CALL_PHONE},1);

    }
}
