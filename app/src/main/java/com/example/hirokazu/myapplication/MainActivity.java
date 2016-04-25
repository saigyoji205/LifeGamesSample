package com.example.hirokazu.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    private static final int ROWS = 15;
    private static final int COLUMNS = 10;
    private boolean[]isAlive = new boolean[ROWS*COLUMNS];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life);
        TableLayout tableLayout = (TableLayout) findViewById(R.id.TableLayout);
        Button button;


        for(int iRow = 0; iRow < ROWS; iRow++){
            TableRow tableRow = new TableRow(this);
            for(int iCol = 0; iCol < COLUMNS; iCol++){
                button = new Button(this);
                button.setId((iRow)*COLUMNS+(iCol+1));
                button.setBackgroundColor(Color.BLACK);
                button.setOnClickListener(new View.OnClickListener() {
                    boolean flg = false;
                    @Override
                    public void onClick(View v) {
                        if(!flg){
                            v.setBackgroundColor(Color.GREEN);
                            flg = true;
                        }else{
                            v.setBackgroundColor(Color.BLACK);
                            flg = false;
                        }
                        Log.d("No.",String.valueOf(v.getId()));

                    }
                });
                tableRow.addView(button);
            }
            tableLayout.addView(tableRow);
        }

/* 動的ボタン生成(配列あり)
        Button[][] buttons= new Button[ROWS][COLUMNS];
        for(int iRow = 0; iRow < ROWS; iRow++){
            TableRow tableRow = new TableRow(this);
            for (int iCol = 0; iCol < COLUMNS; iCol++){
                buttons[iRow][iCol] = new Button(this);
                buttons[iRow][iCol].setId((iRow)*COLUMNS+(iCol+1));
                buttons[iRow][iCol].setBackgroundColor(Color.BLACK);
                buttons[iRow][iCol].setOnClickListener(new View.OnClickListener() {
                    boolean flg = false;
                    @Override
                    public void onClick(View v) {
                        if(!flg){
                            v.setBackgroundColor(Color.GREEN);
                            flg = true;
                        }else{
                            v.setBackgroundColor(Color.BLACK);
                            flg = false;
                        }
                        Log.d("No.",String.valueOf(v.getId()));
                    }
                });
                tableRow.addView(buttons[iRow][iCol]);
            }
            tableLayout.addView(tableRow);
        }
*/


    }
}
