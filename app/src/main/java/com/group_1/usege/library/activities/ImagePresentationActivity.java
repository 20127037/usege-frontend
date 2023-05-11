package com.group_1.usege.library.activities;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.group_1.usege.R;
import com.group_1.usege.model.Image;

import java.util.ArrayList;
import java.util.List;

public class ImagePresentationActivity extends AppCompatActivity {
    Context context;
    List<Image> selectedImages = new ArrayList<>();
    ImageView currentImageView;
    int currentImageIndex = 0;
    int waitingTime = 3000;
    String action = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_presentation);
        context = getApplicationContext();
        Bundle bundle = getIntent().getExtras();
        selectedImages = bundle.getParcelableArrayList("data");

        currentImageView = findViewById(R.id.current_image);
    }

    private class Presentation extends AsyncTask<Void, Integer, String> {
        private void renderImage(Uri imageUri) {
            Glide.with(context)
                    .load(imageUri)
                    .apply(new RequestOptions().centerCrop())
                    .into(currentImageView);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            while (currentImageIndex < selectedImages.size()) {
                publishProgress(currentImageIndex);

                try {
                    Thread.sleep(waitingTime);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                currentImageIndex += 1;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(context, "The presentation ended.", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Uri imageUri = selectedImages.get(values[0]).getUri();
            renderImage(imageUri);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Presentation().execute();
    }

    public void viewPreviousImage(View v) {

    }

    public void viewNextImage(View v) {
    }

    public void starPresentationOver(View v) {
        currentImageIndex = 0;
    }

    public void pausePresentation(View v) {

    }

    public void adjustPresentationProperties(View v) {
        Toast.makeText(this, "This service is not available now", Toast.LENGTH_SHORT).show();
        return;
    }

    public void exportVideo(View v) {
        Toast.makeText(this, "This service is not available now", Toast.LENGTH_SHORT).show();
        return;
    }

    public void backToPreviousActivity(View v) {
        finish();
    }
}