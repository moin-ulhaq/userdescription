package com.example.userdescription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView iv1;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iv1=findViewById(R.id.ivPicture);
        tv1=findViewById(R.id.tvName1);
        tv2=findViewById(R.id.tvName2);
        Intent intent_set=new Intent();
        intent_set.getExtras();

    }
}