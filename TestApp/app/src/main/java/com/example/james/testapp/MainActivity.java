package com.example.james.testapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.james.testapp.view.FullScreenDialog;

public class MainActivity extends AppCompatActivity {

    private final static String URL_MAINPAGE = "theme://zhuti.xiaomi.com/mainpage?miref=cleaner";
    private final static String URL_SETTINGS_THEME = "theme://zhuti.xiaomi.com/settingstheme?isOpen=true";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDeeplink(URL_SETTINGS_THEME);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFullScreenDialog();
            }
        });
    }

    private void processDeeplink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void showFullScreenDialog() {
        FullScreenDialog fullScreenDialog = new FullScreenDialog(this);
        fullScreenDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Toast.makeText(MainActivity.this, "Full screen dialog dismiss!", Toast.LENGTH_SHORT).show();
            }
        });
        fullScreenDialog.show();
    }
}
