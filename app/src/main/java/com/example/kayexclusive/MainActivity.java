package com.example.kayexclusive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.kayexclusive.databinding.ActivityListBinding;
import com.example.kayexclusive.databinding.ActivityMainBinding;
import com.example.kayexclusive.databinding.ActivityPicBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    TextInputEditText name, email, password1, password2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);


        email = findViewById(R.id.email);


        password1 = findViewById(R.id.password1);


        password2 = findViewById(R.id.password2);

    }

    public void Register(View view) {
        String username = name.getText().toString();
        String useremail = email.getText().toString();
        String userpassword1 = password1.getText().toString();
        String userpassword2 = password2.getText().toString();
        Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();


        if (username.isEmpty() && useremail.isEmpty() && userpassword1.isEmpty() && userpassword2.isEmpty()) {

            Toast.makeText(MainActivity.this, "All field is required", Toast.LENGTH_SHORT).show();

        } else {

            if (useremail.contains("@") && useremail.endsWith(".com")) {

                Toast.makeText(MainActivity.this, username + useremail + userpassword1 + userpassword2, Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(MainActivity.this, "Type a valid Email", Toast.LENGTH_SHORT).show();


            }
        }

    }

    public void SignIn(View view){

        Intent intent = new Intent(getApplicationContext(), List.class);
        startActivity(intent);

//        FirstFragment firstFragment = new FirstFragment();
//
//        FragmentTransaction fragmentTr0ansaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragmentContainerView, firstFragment).commit();


    }

}
    

