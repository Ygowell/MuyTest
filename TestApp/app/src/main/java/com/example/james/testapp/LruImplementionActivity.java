package com.example.james.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LruImplementionActivity extends Activity {

    private EditText mSizeEt;
    private EditText mEnterNumEt;
    private TextView mResultTv;
    private Button mSetSizeBtn;
    private Button mAddNumBtn;

    private Integer[] mCacheArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lru_implemention);

        mSizeEt = findViewById(R.id.editText);
        mEnterNumEt = findViewById(R.id.editText2);

        mResultTv = findViewById(R.id.textView3);
        mAddNumBtn = findViewById(R.id.button6);
        mSetSizeBtn = findViewById(R.id.button);

        mSetSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setArraySize();
            }
        });

        mAddNumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewNum();
            }
        });
    }

    private void setArraySize() {
        int size = Integer.parseInt(mSizeEt.getText().toString());
        mCacheArray = new Integer[size];
    }

    private void addNewNum() {
        int num = Integer.parseInt(mEnterNumEt.getText().toString());

        int cacheSize = mCacheArray.length;
        int i = 0;
        for (; i < cacheSize; i++) {
            if (mCacheArray[i] == null) {
                mCacheArray[i] = num;
                break;
            }
        }

        if (i == cacheSize) {
            for (int k = 1; k < cacheSize; k++) {
                mCacheArray[k - 1] = mCacheArray[k];
            }
            mCacheArray[cacheSize - 1] = num;
        }

        printResult();
    }

    private void printResult() {
        int cacheSize = mCacheArray.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cacheSize; i++) {
            stringBuilder.append(mCacheArray[i]);
            stringBuilder.append(" | ");
        }
        mResultTv.setText(stringBuilder.toString());
    }
}
