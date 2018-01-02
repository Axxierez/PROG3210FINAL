package com.example.alex.prog3210final;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends ListActivity {

    private AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        database = AppDatabase.getDatabase(getApplicationContext());
        ArrayList<Map<String, String>> list = buildData();
        String[] from = { "Label", "Text" };
        int[] to = { android.R.id.text1, android.R.id.text2 };

        SimpleAdapter adapter = new SimpleAdapter(this, list,
                android.R.layout.two_line_list_item, from, to);
        setListAdapter(adapter);
    }

    private ArrayList<Map<String, String>> buildData() {
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();

        List<ListViewItem> items = database.itemDao().getAllItems();

        for (int i = 0; i < items.size(); i++) {
            String temp =items.get(i).getBigText();
            list.add(putData(items.get(i).getBigText(),items.get(i).getSmallText()));
        }

        return list;
    }

    private HashMap<String, String> putData(String label, String text) {
        HashMap<String, String> item = new HashMap<String, String>();
        item.put("Label", label);
        item.put("Text", text);
        return item;
    }
}
