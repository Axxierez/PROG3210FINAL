package com.example.alex.prog3210final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddToListViewActivity extends AppCompatActivity {
    private AppDatabase database;

    private EditText listItemLabel;
    private EditText listItemText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = AppDatabase.getDatabase(getApplicationContext());
        setContentView(R.layout.activity_add_to_list_view);
    }

    public void addToListView(View view){
        listItemLabel=(EditText) findViewById(R.id.editBigText);
       listItemText=(EditText) findViewById(R.id.editSmallText);


        String listItemLabelAnswer = listItemLabel.getText().toString();
        String listItemTextAnswer = listItemText.getText().toString();

        database.itemDao().addItem(new ListViewItem(listItemLabelAnswer,listItemTextAnswer));


    }
}
