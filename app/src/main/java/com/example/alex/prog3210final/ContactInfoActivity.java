package com.example.alex.prog3210final;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ContactInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

    }

    public void Email(View view){


        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","alexgalka96@gmail.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Final");
        intent.putExtra(Intent.EXTRA_TEXT, "Hello my name is Anil");
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    public void Call(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + "555-123-4567"));
        startActivity(intent);
    }

}
