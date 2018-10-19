package com.example.delaney.jerseylab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mNameTextView, mNumberTextView;
    private Item mCurrentItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameTextView = findViewById(R.id.name_text);
        mNumberTextView = findViewById(R.id.number_text);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //TODO: (PD 02 -8.44) Snack bars are as easy as toasts
                //TODO: (PD 02 - 0.40) Later make this an add button, this is just a test

                // To practice interacting with the screen
                mCurrentItem = Item.getDefaultItem();
                showCurrentItem();
                

            }
        });
    }

    private void showCurrentItem() {
        mNameTextView.setText(mCurrentItem.getName());
        mNumberTextView.setText(getString(R.string.number_format, mCurrentItem.getNumber()));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // PD - Boiler Plate - This is what's called to make your menu
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //TODO: (PD - 02  -7.48) This is the function that gets called when you press a menu item
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
}
