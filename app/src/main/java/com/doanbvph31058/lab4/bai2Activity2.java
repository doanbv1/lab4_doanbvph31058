package com.doanbvph31058.lab4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bai2Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_main2);

        Button button2 = findViewById(R.id.Baogia);

        EditText edtPrice = findViewById(R.id.priceQuote);

        TextView tv2 = findViewById(R.id.thuKhachCanMua);


        Intent intent = getIntent();
        String price = intent.getStringExtra("name");
        tv2.setText(price);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String priceQuote = edtPrice.getText().toString();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("fromAc2", priceQuote);
                intent.putExtras(bundle);
                setResult(1,intent);
                finish();
            }
        });

    }
}