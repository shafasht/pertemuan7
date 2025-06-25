package com.example.dzikir_shafa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    CardView pagiCard, soreCard, shareApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagiCard = findViewById(R.id.pagi);
        soreCard = findViewById(R.id.petang);
        shareApp = findViewById(R.id.shareapp);

        pagiCard.setOnClickListener(v -> openDzikir("pagi"));
        soreCard.setOnClickListener(v -> openDzikir("petang"));
        shareApp.setOnClickListener(v -> shareApplication());
    }

    private void openDzikir(String kategori) {
        Intent intent = new Intent(MainActivity.this, DzikirActivity.class);
        intent.putExtra("kategori", kategori);
        startActivity(intent);
    }

    private void shareApplication() {
        String shareText = "Assalamu’alaikum! Yuk dzikir bareng lewat aplikasi P7UPI. Download di sini: https://play.google.com/store/apps/details?id=com.example.p7upi";

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, "Bagikan aplikasi lewat:");
        startActivity(shareIntent);
    }
}