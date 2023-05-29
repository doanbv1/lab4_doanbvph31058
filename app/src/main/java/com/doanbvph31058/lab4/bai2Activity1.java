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

public class bai2Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai21);



        Button button1 = findViewById(R.id.gui);

        EditText editText1 = findViewById(R.id.editText);

        TextView tv1 = findViewById(R.id.gia);

        ActivityResultLauncher<Intent> getData = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),

                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 1){// ma code nhan
                            Intent intent = result.getData();
                            if(intent != null){
                                Bundle bundle = intent.getExtras();//lay ve goi du lieu
                                String pricedata = bundle.getString("fromAc2");//lay du lieu theo key
                                tv1.setText(pricedata);
                            }
                        }
                    }
                }
        );

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bai2Activity1.this, bai2Activity2.class);
                intent.putExtra("name", editText1.getText().toString());
                getData.launch(intent);//phai co cai nay thi moi thuc hien dc callback

            }
        });
    }
}