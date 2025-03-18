package com.example.kayexclusive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Lists extends AppCompatActivity implements SelectedItem{

    RecyclerView recyclerView;
    SearchView searchView;
    ArrayList<CustomModel> lists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        searchView = findViewById(R.id.Kaysearch);
        recyclerView = findViewById(R.id.Kay);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
          lists = new ArrayList<>();

        Toast.makeText(this, "I'm here", Toast.LENGTH_LONG).show();
          lists.add(new CustomModel("Flag","Ghana","KKK",R.drawable.v));
        lists.add(new CustomModel("ghana","Ghana","KKK",123));
        lists.add(new CustomModel("Flag","Ghana","KKK",123));
        lists.add(new CustomModel("Flag","Ghana","KKK",123));
        lists.add(new CustomModel("Flag","Ghana","KKK",123));
        lists.add(new CustomModel("Flag","Ghana","KKK",123));
        lists.add(new CustomModel("Flag","Ghana","KKK",123));
        lists.add(new CustomModel("Flag","Ghana","KKK",123));
        lists.add(new CustomModel("Flag","Ghana","KKK",123));



          CustomAdapter customAdapter = new CustomAdapter(lists, this,this);
          recyclerView.setAdapter(customAdapter);
        SearchQuery();
    }

    @Override
    public void onItemClick(CustomModel customData) {

        Intent intent = new Intent(getApplicationContext(), List.class);
        int data = 123;

        String[] product = {customData.getDes(),customData.getTitle(), customData.getTitle()};
        intent.putExtra("Kay",data);

    }
    private void filteredList(String text) {
        ArrayList<CustomModel> filterList = new ArrayList<>();

        for (CustomModel Sdata : lists) {
            if (Sdata.getName().contains(text)){

                filterList.add(Sdata);

            }

        }
        if (filterList.isEmpty()){

            Toast.makeText(this,"I'm here", Toast.LENGTH_SHORT).show();
        }else {

            CustomAdapter myadapter2 = new CustomAdapter(filterList, this, this);

            recyclerView.setAdapter(myadapter2);
        }
    }

    public void SearchQuery(){

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filteredList(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filteredList(newText);
                return false;
            }
        });
    }
}