package com.example.administrator.leafloading;


import android.support.annotation.IntDef;

import static com.example.administrator.leafloading.StartType.BIG;
import static com.example.administrator.leafloading.StartType.LITTLE;
import static com.example.administrator.leafloading.StartType.MIDDLE;


@IntDef({LITTLE,MIDDLE,BIG})
public @interface StartType {
    int LITTLE=0;
    int MIDDLE=1;
    int BIG=2;
}
