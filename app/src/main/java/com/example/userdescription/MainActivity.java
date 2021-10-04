package com.example.userdescription;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    EditText et,et1;
    private DBHandler dbHandler;
    Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=findViewById(R.id.ivImage);
        et=findViewById(R.id.etName);
        et1=findViewById(R.id.etDescription);
        btnadd=findViewById(R.id.btnAdd);

        dbHandler = new DBHandler(MainActivity.this);



        // image update and delete
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String userName = et.getText().toString();
                String userDescription = et1.getText().toString();

                // validating if the text fields are empty or not.
                try {
                    if (userName.isEmpty() || userDescription.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "add values first", Toast.LENGTH_SHORT).show();
                }


                    dbHandler.addNewUser(userName, userDescription);


                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "user has been added.", Toast.LENGTH_SHORT).show();
                et.setText("");
                et1.setText("");


            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to exit ?");

                // Set Alert Title
                builder.setTitle("Alert !");
                builder.setIcon(R.drawable.ic_launcher_background);

                builder.setPositiveButton("pick image from gallary", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext()," gallery image",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("pick image from camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"camera image",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();

                alertDialog.show();


            }
        });
//        Intent intent=new Intent();
//        intent.putExtra("name",et.getText().toString());
//        intent.putExtra("description",et1.getText().toString());
//        startActivity(intent);
    }


}