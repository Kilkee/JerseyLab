package com.example.delaney.jerseylab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mNameTextView, mNumberTextView;
    private Item mCurrentItem;

    private ImageView mJersyView;

    String name;
    int number;
    boolean chkPurple;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentItem = new Item();

        mNameTextView = findViewById(R.id.name_text);
        mNumberTextView = findViewById(R.id.number_text);
        mJersyView = findViewById(R.id.purpleOrGreen);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



        addItem();


            }
        });
    }

    private void addItem() {



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.update_jersey);
        final View view = getLayoutInflater().inflate(R.layout.dialog_add, null,false);
        builder.setView(view);

        final EditText nameEditText = view.findViewById(R.id.edit_name);
        final EditText numberEditText = view.findViewById(R.id.edit_number);

        final CheckBox purple = view.findViewById(R.id.purple);
        final CheckBox green = view.findViewById(R.id.green);
        builder.setView(view);

        purple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // chkPurple = ((CheckBox) view).isChecked();
                chkPurple = false;

            }

        });


        green.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // chkPurple = ((CheckBox) view).isChecked();
                chkPurple = true;

            }

        });


        builder.setNegativeButton(android.R.string.cancel, null);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        name = nameEditText.getText().toString();
        number = Integer.parseInt(numberEditText.getText().toString());
//*******
       // ImageView myImageView = (ImageView)view.findViewById(R.id.jersey_colour);
       // myImageView.setImageResource(R.drawable.green_jersey);
//***********

        mCurrentItem = new Item(name, number, chkPurple);
        showCurrentItem();

    }
});

builder.create().show();



    }




    private void showCurrentItem() {
        mNameTextView.setText(mCurrentItem.getName());
        mNumberTextView.setText(getString(R.string.number_format, mCurrentItem.getNumber()));

        if(mCurrentItem.getColour()) {
            mJersyView.setImageResource(R.drawable.green_jersey);    // This sets mJerseyView to the green Jersey
        } else {
            mJersyView.setImageResource(R.drawable.purple_jersey);   // This sets mJerseyView to the purple Jersey
        }

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
        switch (item.getItemId()){
            case R.id.action_reset:
                mCurrentItem = new Item();
                showCurrentItem();
                return true;
            case R.id.action_settings:
               // startActivity(new Intent(Settings.ACTION_SETTINGS));
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
