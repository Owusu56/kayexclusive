package com.example.kayexclusive;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kayexclusive.databinding.ActivityListBinding;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity {
    ImageView imageView;
    ActivityListBinding listBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBinding = ActivityListBinding.inflate(getLayoutInflater());
        View view = listBinding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        int store = intent.getIntExtra("Kay",1);
        Toast.makeText(this, String.valueOf(store), Toast.LENGTH_SHORT).show();






    }




}


