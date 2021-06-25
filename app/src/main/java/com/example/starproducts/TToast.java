package com.example.starproducts;


import android.app.Activity;
import android.widget.Toast;

import java.nio.channels.AcceptPendingException;

public class TToast {
    public TToast(Activity v, String t) {
        Toast.makeText(v, t, Toast.LENGTH_LONG).show();
    }
};
