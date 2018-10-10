package com.example.james.testapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ProxyInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.james.testapp.view.FullScreenDialog;
import com.muy.thirdlib.utils.ResUtils;

public class MainActivity extends AppCompatActivity {

    private final static String URL_MAINPAGE = "theme://zhuti.xiaomi.com/mainpage?miref=cleaner&S.EXTRA_TAB_ID=ringtone";
    private final static String URL_SETTINGS_THEME = "theme://zhuti.xiaomi.com/settingstheme?isOpen=true";
    private final static String URL_WEB = "theme://zhuti.xiaomi.com/web?miref=cleaner&miback=true";
    private final static String URL_DETAIL_THEME = "theme://zhuti.xiaomi.com/detail?miref=cleaner&S.REQUEST_RES_ONLINE_ID=44f16fd9-c329-4b8d-b95d-4704435b19c0";

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

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testSingleTask();
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDeeplink(URL_WEB);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "onNewIntent", Toast.LENGTH_SHORT).show();
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

    private void testSingleTask() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void processDeeplinkJumpRingtone(View view) {
        processDeeplink(URL_MAINPAGE);
    }

    public void processDeeplinkJumpDetailTheme(View view) {
        processDeeplink(URL_DETAIL_THEME);
    }

    public void callExtraLibToast(View view) {
        ResUtils.showToast(this, "Call ExtraLib Toast!");
    }
}
