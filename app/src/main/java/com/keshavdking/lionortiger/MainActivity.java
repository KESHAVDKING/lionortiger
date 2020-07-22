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


    boolean gameOver=false;

//    int [] corners={0,2,6,8};
    //this line of code will be used to chk for winning cases
    int [][] winingConditions = {{0,1,2},{3,4,4},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
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
        for (int i=0;i<playersChoices.length;i++){
            playersChoices[i]=Player.NONE;
        }
        //        playersChoices[0]=Player.NONE;
//        playersChoices[1]=Player.NONE;
//        playersChoices[2]=Player.NONE;
//        playersChoices[3]=Player.NONE;
//        playersChoices[4]=Player.NONE;
//        playersChoices[5]=Player.NONE;
//        playersChoices[6]=Player.NONE;
//        playersChoices[7]=Player.NONE;
//        playersChoices[8]=Player.NONE;
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


//        boolean isTrue = contains(corners,tiIndex);
//        //chk for winners
//        //corner case
//        if(isTrue){
////            Toast.makeText(this,"corner is clicked",Toast.LENGTH_LONG).show();
//            hrChk(tiIndex,clickedPlayer);
//            vrChk(tiIndex,clickedPlayer);
//            diaChk(tiIndex,clickedPlayer);
//        }
//        else if (tiIndex==4){
//            hrChk(tiIndex,clickedPlayer);
//            vrChk(tiIndex,clickedPlayer);
//            diaChk(tiIndex,clickedPlayer);
//        }else {
//            hrChk(tiIndex,clickedPlayer);
//            vrChk(tiIndex,clickedPlayer);
//        }


        }
/* this was my first case
    //horizontal row chk
    private void hrChk(int i,Player p){

        if(contains(r1,i)){
            for (final int x : r1) {

                if(playersChoices[r1[x]]!=p){
                    return;
                }

            }
            youwon();

        }
        else if (contains(r2,i)){
            for (final int x : r1) {

                if(playersChoices[r2[x]]!=p){
                    return;
                }

            }
            youwon();
        }else if (contains(r3,i)){
            for (final int x : r1) {

                if(playersChoices[r3[x]]!=p){
                    return;
                }
//                youwon();
            }
            youwon();
        }


    }

    //vertical row chk
    private void vrChk(int i,Player p){


        if(contains(c1,i)){
            for ( int x=0;x<3;x++) {

                if(playersChoices[c1[x]] != p){
                    return;
                }

            }
            youwon();
        }
        else if (contains(c2,i)){
            for ( int x=0;x<3;x++) {

                if(playersChoices[c2[x]]!=p){
                    return;
                }

            }
            youwon();
        }else if (contains(c3,i)){
            for ( int x=0;x<3;x++) {

                if(playersChoices[c3[x]]!=p){
                    return;
                }

            }
            youwon();
        }


    }

    //diagonal chk

    private void diaChk(int i,Player p){


        if(contains(d1,i)){
            for ( int x=0;x<3;x++) {

                if(playersChoices[d1[x]]!=p){
                    return;
                }

            }
            youwon();
        }
        else if (contains(d2,i)){
            for ( int x=0;x<3;x++) {

                if(playersChoices[d2[x]]!=p){
                    return;
                }

            }
            youwon();
        }
    }



    public boolean contains(final int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }

    private void youwon(){
        Toast.makeText(this,"you won",Toast.LENGTH_LONG).show();
    }
*/
    }

    private void resetTheGame() {

        for (int i=0;i<playersChoices.length;i++){
            playersChoices[i]=Player.NONE;
        }
        //        playersChoices[0]=Player.NONE;
//        playersChoices[1]=Player.NONE;
//        playersChoices[2]=Player.NONE;
//        playersChoices[3]=Player.NONE;
//        playersChoices[4]=Player.NONE;
//        playersChoices[5]=Player.NONE;
//        playersChoices[6]=Player.NONE;
//        playersChoices[7]=Player.NONE;
//        playersChoices[8]=Player.NONE;

        for (int i=0;i<gridView.getChildCount();i++){
            ImageView imageView = (ImageView) gridView.getChildAt(i);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.2f);
        }

        currentPlayer=Player.ONE;
        gameOver=false;
        btnReset.setVisibility(View.GONE);

    }
}