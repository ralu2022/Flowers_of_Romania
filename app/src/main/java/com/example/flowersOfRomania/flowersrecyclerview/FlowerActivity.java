package com.example.flowersOfRomania.flowersrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.flowersOfRomania.R;

public class FlowerActivity extends AppCompatActivity {
    ImageView imageView;
    TextView nameTextView;
    Button detailsButton;

    Flower flower;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);

        // wire objects with widgets
        nameTextView = findViewById(R.id.nameTextView);
        imageView = findViewById(R.id.imageView);
        detailsButton = findViewById(R.id.button);

        // populate UI
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        flower = (Flower) bundle.getSerializable("flowerData");

        nameTextView.setText(flower.getName()+ " - "+ flower.getType() + " flower of beautiful Romania!");

        String iconName = flower.getImage();
        iconName = iconName.substring(0, iconName.indexOf('.'));

        int imageId = this.getResources()
                .getIdentifier(iconName, "drawable", getPackageName());

        imageView.setImageResource(imageId);

        // deal with button event
        detailsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // make the intent and its bundle
                Bundle bundle = new Bundle();
                bundle.putSerializable("flowerData", flower); // place data in bundle
                Intent intent = new Intent(FlowerActivity.this, DetailsActivity.class);

                // place bundle in intent
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
