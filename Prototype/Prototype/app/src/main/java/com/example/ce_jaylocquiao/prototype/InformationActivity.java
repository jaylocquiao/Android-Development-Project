package com.example.ce_jaylocquiao.prototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ce_jaylocquiao.prototype.Model.Laptop;

public class InformationActivity extends AppCompatActivity {

    private EditText nameFld;
    private EditText colorFld;

    ImageView imageView;
    boolean imageFitToScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);


        //Casting Flds
        nameFld = (EditText) findViewById(R.id.laptopNameTextView);
        colorFld = (EditText) findViewById(R.id.colorTextView);

        Intent intent = getIntent();
        Laptop laptop = (Laptop) intent.getSerializableExtra("laptop");


        nameFld.setText(laptop.getLaptopName());
        colorFld.setText(laptop.getLaptopColor());


    }

        public void deleteImageButton(View view) {
            ImageButton button = (ImageButton) findViewById(R.id.razerBlade1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setVisibility(View.INVISIBLE);
                }
            });
    }

   public void editConfirmation(View view) {
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setMessage("Are you sure you want to edit?");

       builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_LONG).show();
           }
       });

       builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_LONG).show();
           }
       });

       builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               Toast.makeText(getApplicationContext(), "Yes", Toast.LENGTH_LONG).show();
           }
       });

       AlertDialog alert = builder.create();
       alert.show();
   }
}
