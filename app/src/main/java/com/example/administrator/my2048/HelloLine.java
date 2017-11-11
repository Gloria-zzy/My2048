package com.example.administrator.my2048;

/**
 * Created by Administrator on 2017/9/28.
 */

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class HelloLine extends FrameLayout {

    private int num = 0;
    private TextView label;

    public HelloLine(Context context) {
        super(context);

        label = new TextView(getContext());
        label.setTextSize(32);
        label.setGravity(Gravity.CENTER);
        label.setBackgroundColor(0xffbbada0);

        LayoutParams lp = new LayoutParams(-1, -1);
        lp.setMargins(10, 10, 0, 0);
        addView(label, lp);

    }

}
