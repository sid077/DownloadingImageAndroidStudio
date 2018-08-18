package com.siddhant.downloadingimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DownloadImage extends AsyncTask<String,Void,Bitmap> {
    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(strings[0]);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return bitmap;
    }
}
