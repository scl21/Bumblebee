package com.example.bumblebee.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bumblebee.Database.Repository;
import com.example.bumblebee.Entity.Product;
import com.example.bumblebee.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterHere(View view) {
        Intent intent = new Intent(MainActivity.this, ProductList.class);
        startActivity(intent);
        Repository repo = new Repository(getApplication());
        Product product = new Product(1, "Tricycle", 10.99);
        repo.update(product);
    }
}