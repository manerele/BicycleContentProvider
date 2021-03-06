package com.example.josemanuelgarciacruz.bicyclecontentprovider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.josemanuelgarciacruz.bicyclecontentprovider.bicycle.BicycleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonShowBibycles = (Button) findViewById(R.id.buttonShowBiccycles);
        buttonShowBibycles.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, BicycleActivity.class);
        startActivity(intent);
    }
}
