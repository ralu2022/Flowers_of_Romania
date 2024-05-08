package com.example.flowersOfRomania.flowersrecyclerview;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.flowersOfRomania.R;

public class WebActivity extends AppCompatActivity {
    EditText urlEditText;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        // bind objects
        urlEditText = findViewById(R.id.urlEditText);
        webView = findViewById(R.id.webView);

        // get url from activity details
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String url = bundle.getString("flowerUrl");

        // populate view
        urlEditText.setText(url);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        Button button;

        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(WebActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
