package com.example.flowersOfRomania.flowersrecyclerview;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.flowersOfRomania.R;

public class DetailsActivity extends AppCompatActivity {
    TextView nameTextView;
    TextView typeTextView;
    TextView descriptionTextView;
    TextView imageTextView;
    Button webButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // wire objects with widgets
        nameTextView = findViewById(R.id.nameTextView);
        typeTextView = findViewById(R.id.typeTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        imageTextView = findViewById(R.id.imageTextView);
        webButton = findViewById(R.id.webButton);

        // get intent and extract data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Flower flower = (Flower) bundle.getSerializable("flowerData");

        // populate objects with data
        nameTextView.setText(flower.getName());
        typeTextView.setText(flower.getType());
        descriptionTextView.setText(flower.getDescription());
        imageTextView.setText(flower.getImage());

        // deal with button event
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // make intent and its bundle
                Bundle bundle = new Bundle();
                bundle.putString("flowerUrl", flower.getUrl());

                Intent intent = new Intent(DetailsActivity.this, WebActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
