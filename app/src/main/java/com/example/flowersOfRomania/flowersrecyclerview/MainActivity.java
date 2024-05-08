package com.example.flowersOfRomania.flowersrecyclerview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowersOfRomania.R;

public class MainActivity extends AppCompatActivity {
    RecyclerView listView;
    DataAdapter adapter;
    XMLFlowersData data;

        protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // generate data
        data = new XMLFlowersData(this);

        // bind the list
        listView = findViewById(R.id.listView);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setItemAnimator(new DefaultItemAnimator());

        // make adapter
        adapter = new DataAdapter(data.getFlowersData());
        listView.setAdapter(adapter);
    }
}
