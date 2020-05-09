package com.example.ce_jaylocquiao.prototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ce_jaylocquiao.prototype.Model.ILaptopSvc;
import com.example.ce_jaylocquiao.prototype.Model.Laptop;
import com.example.ce_jaylocquiao.prototype.Model.LaptopSvcCacheImpl;

public class MainActivity extends AppCompatActivity {


    private ListView myListView;
    private ILaptopSvc laptopSvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       myListView = (ListView)findViewById(R.id.myListView);
       laptopSvc = new LaptopSvcCacheImpl();

       //initWithStrings();
       initWithEntities();
    }

    private void initWithStrings() {
        final String laptopNames[] = laptopSvc.getLaptopName();
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview_row, laptopNames);
        myListView.setAdapter(adapter);
    }

    private void initWithEntities() {
        final Laptop laptopList[] = laptopSvc.getLaptop();
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview_row, laptopList);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("onItemClickListener", "position: " + i);
                Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                intent.putExtra("name", laptopList[i].getLaptopName());
                intent.putExtra("laptop", laptopList[i]);
                startActivity(intent);
            }
        });
    }

    public void editConfirmation(View view) {
        AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to edit?");

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Cancled", Toast.LENGTH_LONG).show();
            }
        });
    }
}
