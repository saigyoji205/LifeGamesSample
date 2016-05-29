package com.example.hirokazu.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    private static final int COLUMNS = 40;
    private boolean[] isAlive;
    private TableLayout mTableLayout;


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mTableLayout= (TableLayout) findViewById(R.id.TableLayout);
        final int width = mTableLayout.getWidth();
        final int height = mTableLayout.getHeight();
        final int cellSize = (int) ((double) width / (double) COLUMNS);
        final int rows = height / cellSize;
        isAlive = new boolean[rows * COLUMNS];
        Button[] button = new Button[rows * COLUMNS];
        doDraw(cellSize, rows, button);
    }

    private void doDraw(int cellSize, int rows, Button[] button) {
        final TableLayout tableLayout = mTableLayout;
        for (int iRow = 0; iRow < rows; iRow++) {
            TableRow tableRow = new TableRow(this);
            for (int iCol = 0; iCol < COLUMNS; iCol++) {
                button[(iRow) * COLUMNS + (iCol)] = new Button(this);
                button[(iRow) * COLUMNS + (iCol)].setBackgroundColor(Color.BLACK);
                button[(iRow) * COLUMNS + (iCol)].setId((iRow) * COLUMNS + (iCol));
                button[(iRow) * COLUMNS + (iCol)].setOnClickListener(new View.OnClickListener() {
                    boolean flg;
                    @Override
                    public void onClick(View v) {
                        flg = isAlive[v.getId()];
                        if (!flg) {
                            v.setBackgroundColor(Color.GREEN);
                        } else {
                            v.setBackgroundColor(Color.BLACK);
                        }
                        isAlive[v.getId()] = !flg;
                        Log.d(String.valueOf(v.getId()), isAlive[v.getId()] ? "true" : "false");
                    }
                });
                tableRow.addView(button[(iRow) * COLUMNS + (iCol)], cellSize, cellSize); //変更箇所
            }
            tableLayout.addView(tableRow); //変更箇所
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life);
    }
}
