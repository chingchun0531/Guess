package com.tom.guess;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();
    int secret= new Random().nextInt(10)+1;
    EditText edNumber;
    TextView edCounter;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG,"secret" + secret);
        edNumber = findViewById(R.id.num);
        edCounter = findViewById(R.id.counter);
        edCounter.setText(counter+"");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void result(View view){
        int number =Integer.parseInt(edNumber.getText().toString());
        counter++;
        edCounter.setText(counter+"");
        if(secret>number){
           new AlertDialog.Builder(MainActivity.this)
                   .setTitle("ha")
                   .setMessage("Bigger")
                   .setPositiveButton("OK",null)
                   .show();
        }else if(secret<number){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("ha")
                    .setMessage("smaller")
                    .setPositiveButton("OK",null)
                    .show();
        }else{
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("ha")
                    .setMessage("Bingo")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            secret= new Random().nextInt(10)+1;
                            counter = 0;
                            edCounter.setText(counter+"");
                        }
                    })
                    .show();
        }
    }
    }


