package com.siddhant.downloadingimage;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;
//for downloading an image and displaying it into app
public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Bitmap bitmap;
    DownloadImage downloadImage=new DownloadImage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showDownloadedImage(View view) {
        imageView=findViewById(R.id.imageView);
        try {
            bitmap = downloadImage.execute("https://i.pinimg.com/originals/cb/2c/db/cb2cdb82fa1d915a1ebb727984422d17.png").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        imageView.setImageBitmap(bitmap);
    }
}
