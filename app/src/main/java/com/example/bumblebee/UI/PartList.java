package com.example.bumblebee.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bumblebee.Database.Repository;
import com.example.bumblebee.Entity.Product;
import com.example.bumblebee.R;


public class PartList extends AppCompatActivity {
    EditText productName;
    EditText productPrice;
    int productId;
    String name;
    Double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_list);
        productName = findViewById(R.id.editProductName);
        productPrice = findViewById(R.id.editProductPrice);
        productId = getIntent().getIntExtra("id", -1);
        name = getIntent().getStringExtra("name");
        price = getIntent().getDoubleExtra("price", 0.00);
        productName.setText(name);
        productPrice.setText(price.toString());
    }

    public void saveParts(View view) {
        Repository repository = new Repository(getApplication());
        Product product;

        if (productId == -1) {
            int newId = repository.getAllProducts().get(repository.getAllProducts().size() - 1).getProductId() + 1;
            product = new Product(newId, productName.getText().toString(), Double.parseDouble(productPrice.getText().toString()));
            repository.insert(product);
        } else {
            product = new Product(productId, productName.getText().toString(), Double.parseDouble(productPrice.getText().toString()));
            repository.update(product);
        }

    }

    public void goToPartDetail(View view) {
        Intent intent = new Intent(PartList.this, PartDetail.class);
        startActivity(intent);
    }
}