package com.example.administrator.my2048;

/**
 * Created by Administrator on 2017/9/28.
 */

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {

    private int t_defaultSize = 42;
    private int num = 0;
    private TextView label;
    private View background;

    public Card(Context context) {
        super(context);

        LayoutParams lp = null;

        background = new View(getContext());
        lp = new LayoutParams(-1, -1);
        lp.setMargins(10, 10, 0, 0);
        background.setBackgroundColor(0x33ffffff);
        addView(background, lp);

        label = new TextView(getContext());
        label.setTextSize(t_defaultSize);
        label.setGravity(Gravity.CENTER);

        lp = new LayoutParams(-1, -1);
        lp.setMargins(10, 10, 0, 0);
        addView(label, lp);

        setNum(0);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;

        if (num <= 0) {
            label.setText("");
        } else {
            label.setText(num + "");
        }
        switch (num) {
            case 0:
                label.setBackgroundColor(0x33ffffff);
                label.setTextSize(t_defaultSize);
                break;
            case 2:
                label.setBackgroundColor(0xffeee4da);
                label.setTextSize(t_defaultSize);
                break;
            case 4:
                label.setBackgroundColor(0xffede0c8);
                label.setTextSize(t_defaultSize);
                break;
            case 8:
                label.setBackgroundColor(0xfff2b179);
                label.setTextSize(t_defaultSize);
                break;
            case 16:
                label.setBackgroundColor(0xfff59563);
                label.setTextSize(t_defaultSize);
                break;
            case 32:
                label.setBackgroundColor(0xfff67c5f);
                label.setTextSize(t_defaultSize);
                break;
            case 64:
                label.setBackgroundColor(0xfff65e3b);
                label.setTextSize(t_defaultSize);
                break;
            case 128:
                label.setBackgroundColor(0xffedcf72);
                label.setTextSize(t_defaultSize);
                break;
            case 256:
                label.setBackgroundColor(0xffedcc61);
                label.setTextSize(t_defaultSize);
                break;
            case 512:
                label.setBackgroundColor(0xffedc850);
                label.setTextSize(t_defaultSize);
                break;
            case 1024:
                label.setBackgroundColor(0xffedc53f);
                label.setTextSize(t_defaultSize - 8);
                break;
            case 2048:
                label.setBackgroundColor(0xffedc22e);
                label.setTextSize(t_defaultSize - 8);
                break;
            case 4096:
                label.setBackgroundColor(0xffFF4040);
                label.setTextSize(t_defaultSize - 8);
                break;
            default:
                label.setBackgroundColor(0xff3c3a32);
                break;
        }
    }

    public boolean equals(Card o) {
        return getNum() == o.getNum();
    }

    protected Card clone() {
        Card c = new Card(getContext());
        c.setNum(getNum());
        return c;
    }

    public TextView getLabel() {
        return label;
    }
}
