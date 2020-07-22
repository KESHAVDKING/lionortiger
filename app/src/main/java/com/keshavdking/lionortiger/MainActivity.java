package com.keshavdking.lionortiger;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

enum Player{
    ONE,TWO,NONE
}

public class MainActivity extends AppCompatActivity {

//    Player [][] arrayOfArray=new  Player[3][3] ;

    Player playersChoices []=new Player[9];

    Button btnReset;
    GridLayout gridView;
    private int count=1;


    boolean gameOver=false;

//    int [] corners={0,2,6,8};
    //this line of code will be used to chk for winning cases
    int [][] winingConditions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
//
//    private int [] r1={0,1,2};
//    private int [] r2={3,4,5};
//    private int [] r3={6,7,8};
//    private int [] c1={0,3,6};
//    private int [] c2={1,4,7};
//    private int [] c3={2,5,8};
//    private int [] d1={0,4,8};
//    private int [] d2={2,4,6};





    private Player currentPlayer=Player.ONE;
//    private Player clickedPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables();

        btnReset=findViewById(R.id.btnReset);
        gridView=findViewById(R.id.gridLayout);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTheGame();
            }


        });

    }
// this method is added directly to the image view in design part
    public void imageIsTapped(View tappedImage) {

        if (!gameOver) {
            count++;
            ImageView imageView = (ImageView) tappedImage;
            imageView.setTranslationX(-2000);
            final int tiIndex = Integer.parseInt(imageView.getTag().toString());
//        Toast.makeText(this,tiIndex+"is tapped",Toast.LENGTH_SHORT).show();

            //insert value in array
            playersChoices[tiIndex] = currentPlayer;

            //set image view
            if (currentPlayer == Player.ONE) {
                imageView.setImageResource(R.drawable.lion);
//            clickedPlayer=currentPlayer;
                currentPlayer = Player.TWO;
            } else {
                imageView.setImageResource(R.drawable.tiger);
//            clickedPlayer=currentPlayer;
                currentPlayer = Player.ONE;
            }

            //does the animation
            imageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);

            //now we need to chk for conditions and other settings

            for (int[] wincondition : winingConditions) {
                if (playersChoices[wincondition[0]] == playersChoices[wincondition[1]] && playersChoices[wincondition[1]] == playersChoices[wincondition[2]] && playersChoices[wincondition[2]] != Player.NONE) {
                    if (currentPlayer == Player.ONE) {
                        Toast.makeText(this, "Tiger wins", Toast.LENGTH_SHORT).show();
                    } else Toast.makeText(this, "Lion wins", Toast.LENGTH_SHORT).show();

                    gameOver = true;
                    btnReset.setVisibility(View.VISIBLE);

                }
            }


            if(count>=10){
                Toast.makeText(this,"Game Over Well Played No One wins ",Toast.LENGTH_SHORT).show();
                btnReset.setVisibility(View.VISIBLE);
                gameOver=true;
            }


        }

    }

    private void resetTheGame() {

        count=1;
        initVariables();

        for (int i=0;i<gridView.getChildCount();i++){
            ImageView imageView = (ImageView) gridView.getChildAt(i);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.2f);
        }

        currentPlayer=Player.ONE;
        gameOver=false;
        btnReset.setVisibility(View.GONE);

    }

    private void initVariables(){
        for (int i=0;i<playersChoices.length;i++){
            playersChoices[i]=Player.NONE;
        }

    }
}