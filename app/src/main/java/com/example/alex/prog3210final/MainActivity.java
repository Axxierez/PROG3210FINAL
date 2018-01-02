package com.example.alex.prog3210final;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = AppDatabase.getDatabase(getApplicationContext());
        setContentView(R.layout.activity_main);
        new DownloadImageTask((ImageView) findViewById(R.id.asyncImage))
                .execute("http://riot-web-cdn.s3-us-west-1.amazonaws.com/lolesports/s3fs-public/styles/centered/public/genericlcslogo_1.png?HZrefvUtQ6mHmPfurPqrzDAkmoDFI11A&itok=cj1Xybn1");
    }


    public void ShowContactInfo(View view){
            startActivity(new Intent(this,ContactInfoActivity.class));
    }
    public void ShowDataEntry(View view){
        Intent intent = new Intent(this, AddToListViewActivity.class);
        startActivity(intent);
    }

    public void ShowListView(View view){
            Intent intent = new Intent(this, ListViewActivity.class);
            startActivity(intent);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                mIcon11 = BitmapFactory.decodeStream(new java.net.URL(urldisplay).openStream());
            } catch (Exception e) {
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    public void ToastRandomItem(View view){
        Toast.makeText(getApplicationContext(), database.itemDao().getRandomItem().getSmallText(), Toast.LENGTH_SHORT).show();
    }
}
