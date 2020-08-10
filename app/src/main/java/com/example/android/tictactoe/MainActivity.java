package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true;
    int activePlayer =0;
    int []gameState ={ 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 }; //0-> x and 1 -> 0 and 2 -> blank
    int[][]winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                          {0,3,6}, {1,4,7}, {2,5,8},
                          {0,4,8}, {2,4,6}};
    int baaji = 0;
    int count = 0;
    public void playerTap(View view) {
        ImageView img = (ImageView)view;
        int tapPosition = Integer.parseInt(img.getTag().toString());
        TextView status = (TextView)findViewById(R.id.status);
        if(!gameActive){
            gameReset(view);
        }
        else if(gameState[tapPosition]==2  ){
            if(activePlayer==0){
                activePlayer =1;
                img.setImageResource(R.drawable.o);
                gameState[tapPosition]=1;
                status.setText("IT'S YOUR TURN X");
                count++;
                baaji=1;
                if(count==9){
                    baaji=0;
                }
            }
            else{
                img.setImageResource(R.drawable.x);
                activePlayer=0;
                gameState[tapPosition]=0;
                status.setText("IT'S YOUR TURN 0");
                count++;
                baaji=2;
                if(count==9){
                    baaji=0;
                }
            }
            // Check if any player has won
            for(int[] winPosition : winPositions){
                if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                        gameState[winPosition[1]] == gameState[winPosition[2]] &&
                        gameState[winPosition[0]] !=2 ){
                    //somebody won
                    gameActive=false;
                    String Winner;
                    if(gameState[winPosition [0]]==0){
                        Winner = "X Has Won";
                                           }
                    else {
                        Winner = "O Has Won";
                    }
                    status.setText(Winner);
                }

            }
            if(baaji!=1&&baaji!=2&&count==9) {
                for (int[] winPosition : winPositions) {
                    if (!(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                            gameState[winPosition[1]] == gameState[winPosition[2]] &&
                            gameState[winPosition[0]] != 2)) {
                        //match tie
                        gameActive = false;
                        String Winner;
                        Winner = "The Match Is A Tie";
                        status.setText(Winner);
                    }

                }
            }
        }


    }
    void gameReset(View view){
        gameActive = true;
        for (int i =0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        baaji=0;
        count=0;
        TextView status = (TextView)findViewById(R.id.status);
        status.setText("TAP TO PLAY");




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


}
