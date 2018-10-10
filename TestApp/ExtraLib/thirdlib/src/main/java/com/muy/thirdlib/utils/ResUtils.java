package com.muy.thirdlib.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by james on 9/30/18.
 */

public class ResUtils {

    public static void showToast(Context context, String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }
}
