package com.example.administrator.my2048;

/**
 * Created by Administrator on 2017/9/27.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class GameView extends GridLayout {
    public GameView(Context context) {
        super(context);
        initGameView();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGameView();
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initGameView();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GameView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initGameView() {
        setBackgroundColor(0xffbbada0);
        setColumnCount(4);


        setOnTouchListener(new OnTouchListener() {
            private float startX, startY, offsetX, offsetY;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        offsetX = event.getX() - startX;
                        offsetY = event.getY() - startY;

                        if (Math.max(offsetX, offsetY) < 10) {
                            HelloLine hl = new HelloLine(getContext());
                            addView(hl, 10, 0);
                        }

                        if (Math.abs(offsetX) > Math.abs(offsetY)) {
                            if (offsetX < -20) {

                                // 存储上一次的表格
                                if (step < 10) {
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[step][i][j].setNum(cardsMap[i][j].getNum());
                                        }
                                    }

                                    // 存储上一次的分数
                                    preScore[step] = MainActivity.getMainActivity().getScore();
                                    step++;

                                    // 实例化数组元素，为下次存储表格做准备
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[step][i][j] = new Card(getContext());
                                        }
                                    }

                                } else {

                                    step = 10;

                                    // 移动数组元素以腾出空间给上一次的表格
                                    for (int p = 0; p < 9; p++) {
                                        for (int i = 0; i < 4; i++) {
                                            for (int j = 0; j < 4; j++) {
                                                preMap[p][i][j].setNum(preMap[p + 1][i][j].getNum());
                                            }
                                        }
                                    }

                                    // 存储上一次的表格
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[9][i][j].setNum(cardsMap[i][j].getNum());
                                        }
                                    }

                                    // 移动数组元素以腾出空间给上一次的分数
                                    for (int p = 0; p < 9; p++) {
                                        preScore[p] = preScore[p + 1];
                                    }

                                    // 存储上一次的分数
                                    preScore[9] = MainActivity.getMainActivity().getScore();
                                }

                                swipeLeft();
                            } else if (offsetX > 20) {

                                // 存储上一次的表格
                                if (step < 10) {
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[step][i][j].setNum(cardsMap[i][j].getNum());
                                        }
                                    }

                                    // 存储上一次的分数
                                    preScore[step] = MainActivity.getMainActivity().getScore();
                                    step++;

                                    // 实例化数组元素，为下次存储表格做准备
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[step][i][j] = new Card(getContext());
                                        }
                                    }

                                } else {

                                    step = 10;

                                    // 移动数组元素以腾出空间给上一次的表格
                                    for (int p = 0; p < 9; p++) {
                                        for (int i = 0; i < 4; i++) {
                                            for (int j = 0; j < 4; j++) {
                                                preMap[p][i][j].setNum(preMap[p + 1][i][j].getNum());
                                            }
                                        }
                                    }

                                    // 存储上一次的表格
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[9][i][j].setNum(cardsMap[i][j].getNum());
                                        }
                                    }

                                    // 移动数组元素以腾出空间给上一次的分数
                                    for (int p = 0; p < 9; p++) {
                                        preScore[p] = preScore[p + 1];
                                    }

                                    // 存储上一次的分数
                                    preScore[9] = MainActivity.getMainActivity().getScore();
                                }

                                swipeRight();
                            }
                        } else {
                            if (offsetY < -20) {

                                // 存储上一次的表格
                                if (step < 10) {
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[step][i][j].setNum(cardsMap[i][j].getNum());
                                        }
                                    }

                                    // 存储上一次的分数
                                    preScore[step] = MainActivity.getMainActivity().getScore();
                                    step++;

                                    // 实例化数组元素，为下次存储表格做准备
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[step][i][j] = new Card(getContext());
                                        }
                                    }

                                } else {

                                    step = 10;

                                    // 移动数组元素以腾出空间给上一次的表格
                                    for (int p = 0; p < 9; p++) {
                                        for (int i = 0; i < 4; i++) {
                                            for (int j = 0; j < 4; j++) {
                                                preMap[p][i][j].setNum(preMap[p + 1][i][j].getNum());
                                            }
                                        }
                                    }

                                    // 存储上一次的表格
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[9][i][j].setNum(cardsMap[i][j].getNum());
                                        }
                                    }

                                    // 移动数组元素以腾出空间给上一次的分数
                                    for (int p = 0; p < 9; p++) {
                                        preScore[p] = preScore[p + 1];
                                    }

                                    // 存储上一次的分数
                                    preScore[9] = MainActivity.getMainActivity().getScore();
                                }
                                swipeUp();
                            } else if (offsetY > 20) {

                                // 存储上一次的表格
                                if (step < 10) {
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[step][i][j].setNum(cardsMap[i][j].getNum());
                                        }
                                    }

                                    // 存储上一次的分数
                                    preScore[step] = MainActivity.getMainActivity().getScore();
                                    step++;

                                    // 实例化数组元素，为下次存储表格做准备
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[step][i][j] = new Card(getContext());
                                        }
                                    }

                                } else {

                                    step = 10;

                                    // 移动数组元素以腾出空间给上一次的表格
                                    for (int p = 0; p < 9; p++) {
                                        for (int i = 0; i < 4; i++) {
                                            for (int j = 0; j < 4; j++) {
                                                preMap[p][i][j].setNum(preMap[p + 1][i][j].getNum());
                                            }
                                        }
                                    }

                                    // 存储上一次的表格
                                    for (int i = 0; i < 4; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            preMap[9][i][j].setNum(cardsMap[i][j].getNum());
                                        }
                                    }

                                    // 移动数组元素以腾出空间给上一次的分数
                                    for (int p = 0; p < 9; p++) {
                                        preScore[p] = preScore[p + 1];
                                    }

                                    // 存储上一次的分数
                                    preScore[9] = MainActivity.getMainActivity().getScore();
                                }

                                swipeDown();
                            }
                        }
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int cardWidth = (Math.min(w, h) - 10) / 4;

        addCards(cardWidth, cardWidth);

        startGame();
    }

    private void addCards(int cardWidth, int cardHeight) {
        Card c;

        for (int y = 0; y < Config.LINES; y++) {


            for (int x = 0; x < 4; x++) {
                c = new Card(getContext());
                addView(c, cardWidth, cardHeight);

                cardsMap[x][y] = c;
                preMap[step][x][y] = new Card(getContext());
            }
        }
    }

    public void startGame() {
        MainActivity aty = MainActivity.getMainActivity();
        aty.clearScore();
        aty.showBestScore(aty.getBestScore());
        step = 0;

        for (int y = 0; y < Config.LINES; y++) {
            for (int x = 0; x < Config.LINES; x++) {
                cardsMap[x][y].setNum(0);
            }
        }

        cardsMap[0][0].setNum(1024);

        addRandomNum();
        addRandomNum();
    }

    // 撤销上一次操作
    public void Undo() {
        step--;
        if (step >= 0) {
            MainActivity.getMainActivity().setScore(preScore[step]);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    cardsMap[i][j].setNum(preMap[step][i][j].getNum());
                }
            }
        }
        if (step < 0) {
            step = 0;
        }

    }

    private void addRandomNum() {

        emptyPoints.clear();

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (cardsMap[x][y].getNum() <= 0) {
                    emptyPoints.add(new Point(x, y));
                }
            }
        }

        if (emptyPoints.size() > 0) {
            Point p = emptyPoints.remove((int) (Math.random() * emptyPoints.size()));
            cardsMap[p.x][p.y].setNum(Math.random() > 0.1 ? 2 : 4);

            MainActivity.getMainActivity().getAnimLayer().createScaleTo1(cardsMap[p.x][p.y]);
        }

    }

    private void swipeLeft() {
        boolean merge = false;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                for (int x1 = x + 1; x1 < 4; x1++) {
                    if (cardsMap[x1][y].getNum() > 0) {
                        if (cardsMap[x][y].getNum() == 0) {
                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
                            cardsMap[x1][y].setNum(0);
                            merge = true;

                            x--;
                        } else if (cardsMap[x][y].equals(cardsMap[x1][y])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum() * 2);
                            cardsMap[x1][y].setNum(0);
                            merge = true;
                            MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomNum();
            checkComplete();

        }
    }

    private void swipeRight() {
        boolean merge = false;

        for (int y = 0; y < 4; y++) {
            for (int x = 3; x >= 0; x--) {
                for (int x1 = x - 1; x1 >= 0; x1--) {
                    if (cardsMap[x1][y].getNum() > 0) {
                        if (cardsMap[x][y].getNum() == 0) {
                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
                            cardsMap[x1][y].setNum(0);
                            merge = true;

                            x++;
                        } else if (cardsMap[x][y].equals(cardsMap[x1][y])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum() * 2);
                            cardsMap[x1][y].setNum(0);
                            merge = true;

                            MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomNum();
            checkComplete();

        }
    }

    private void swipeUp() {
        boolean merge = false;

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                for (int y1 = y + 1; y1 < 4; y1++) {
                    if (cardsMap[x][y1].getNum() > 0) {
                        if (cardsMap[x][y].getNum() == 0) {
                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
                            cardsMap[x][y1].setNum(0);
                            merge = true;

                            y--;
                        } else if (cardsMap[x][y].equals(cardsMap[x][y1])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum() * 2);
                            cardsMap[x][y1].setNum(0);
                            merge = true;

                            MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomNum();
            checkComplete();
        }
    }

    private void swipeDown() {
        boolean merge = false;

        for (int x = 0; x < 4; x++) {
            for (int y = 3; y >= 0; y--) {
                for (int y1 = y - 1; y1 >= 0; y1--) {
                    if (cardsMap[x][y1].getNum() > 0) {
                        if (cardsMap[x][y].getNum() == 0) {
                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
                            cardsMap[x][y1].setNum(0);
                            merge = true;

                            y++;
                        } else if (cardsMap[x][y].equals(cardsMap[x][y1])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum() * 2);
                            cardsMap[x][y1].setNum(0);
                            merge = true;

                            MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomNum();
            checkComplete();
        }
    }

    private void checkComplete() {
        boolean complete = true;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (cardsMap[x][y].getNum() == 0 ||
                        (x > 0 && cardsMap[x][y].equals(cardsMap[x - 1][y])) ||
                        (x < 3 && cardsMap[x][y].equals(cardsMap[x + 1][y])) ||
                        (y > 0 && cardsMap[x][y].equals(cardsMap[x][y - 1])) ||
                        (y < 3 && cardsMap[x][y].equals(cardsMap[x][y + 1]))) {
                    complete = false;
                }
            }
        }
        if (complete) {
            new AlertDialog.Builder(getContext()).setTitle("hello").setMessage("GameOver!").setPositiveButton("try agian", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startGame();
                }
            }).show();
        }
    }

    // 测试文字大小
    private void sizeTest() {
        cardsMap[0][0].setNum(512);
    }

    private int[] preScore = new int[11];
    private int step = 0;
    private Card[][][] preMap = new Card[11][4][4];
    private Card[][] cardsMap = new Card[4][4];
    private List<Point> emptyPoints = new ArrayList<Point>();

}
