package com.example.anyel.a2048;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class ActivityGame extends AppCompatActivity {

    private     int score;
    private int TAM = 4;
    protected    int[][] table = new int[TAM][TAM];
    private float firstTouchX;
    private float firstTouchY;
    private float finishTouchX;
    private float finishTouchY;
    private int[][] idImag = new int[TAM][TAM];
    private int[] idImagDrawable = new int[24];
    private int[] idImagDir = new int[24];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Bundle extras = getIntent().getExtras();
        captureBack();
        initId();
        String name = extras.getString(getResources().getString(R.string.title_nick));
        configureSubTitle(name);
        travelTableInit();
        firstTwoFile();

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            Intent i = new Intent(ActivityGame.this, RegisterGamer.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    private void initId(){
        idImag[0][0] = R.id.f00;
        idImag[0][1] = R.id.f01;
        idImag[0][2] = R.id.f02;
        idImag[0][3] = R.id.f03;
        idImag[1][0] = R.id.f10;
        idImag[1][1] = R.id.f11;
        idImag[1][2] = R.id.f12;
        idImag[1][3] = R.id.f13;
        idImag[2][0] = R.id.f20;
        idImag[2][1] = R.id.f21;
        idImag[2][2] = R.id.f22;
        idImag[2][3] = R.id.f23;
        idImag[3][0] = R.id.f30;
        idImag[3][1] = R.id.f31;
        idImag[3][2] = R.id.f32;
        idImag[3][3] = R.id.f33;

        idImagDrawable[0] = R.drawable.f2;
        idImagDrawable[1] = R.drawable.f4;
        idImagDrawable[2] = R.drawable.f8;
        idImagDrawable[3] = R.drawable.f16;
        idImagDrawable[4] = R.drawable.f32;
        idImagDrawable[5] = R.drawable.f64;
        idImagDrawable[6] = R.drawable.f128;
        idImagDrawable[7] = R.drawable.f256;
        idImagDrawable[8] = R.drawable.f512;
        idImagDrawable[9] = R.drawable.f1024;
        idImagDrawable[10] = R.drawable.f2048;
        idImagDrawable[11] = R.drawable.f4096;
        idImagDrawable[12] = R.drawable.f8192;
        idImagDrawable[13] = R.drawable.f16384;
        idImagDrawable[14] = R.drawable.f32768;
        idImagDrawable[15] = R.drawable.f65536;
        idImagDrawable[16] = R.drawable.f131072;
        idImagDrawable[17] = R.drawable.f262144;
        idImagDrawable[18] = R.drawable.f524288;
        idImagDrawable[19] = R.drawable.f1048576;
        idImagDrawable[20] = R.drawable.f2097152;
        idImagDrawable[21] = R.drawable.f4194304;
        idImagDrawable[22] = R.drawable.f8388608;
        idImagDrawable[23] = R.drawable.f16777216;

        idImagDir[0] = 2;
        idImagDir[1] = 4;
        idImagDir[2] = 8;
        idImagDir[3] = 16;
        idImagDir[4] = 32;
        idImagDir[5] = 64;
        idImagDir[6] = 128;
        idImagDir[7] = 256;
        idImagDir[8] = 512;
        idImagDir[9] = 1024;
        idImagDir[10] = 2048;
        idImagDir[11] = 4096;
        idImagDir[12] = 8192;
        idImagDir[13] = 16384;
        idImagDir[14] = 32768;
        idImagDir[15] = 65536;
        idImagDir[16] = 131072;
        idImagDir[17] = 262144;
        idImagDir[18] = 524288;
        idImagDir[19] = 1048576;
        idImagDir[20] = 2097152;
        idImagDir[21] = 4194304;
        idImagDir[22] = 8388608;
        idImagDir[23] = 16777216;
    }
    protected void configureSubTitle(String nickGamer){
        TypeFacePersonality typeFP = new TypeFacePersonality(this);

        TextView lookNickGamer = (TextView)findViewById(R.id.nick);
        lookNickGamer.setTypeface(typeFP.roboTitle);
        lookNickGamer.setText(nickGamer);

        TextView score  = (TextView)findViewById(R.id.score);
        score.setTypeface(typeFP.dowlinkTitle);

        TextView cantScore  = (TextView)findViewById(R.id.cantScore);
        cantScore.setTypeface(typeFP.dowlinkTitle);
    }
    public void captureBack() {
        ImageView Back = (ImageView) findViewById(R.id.atras);
        Back.setOnClickListener(new  View.OnClickListener(){
            // @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityGame.this, RegisterGamer.class);
                startActivity(i);
                finish();

            }
        });
    }

	protected	void travelTableInit(){
        for(int i=0; i< TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                table[i][j]= 0;
                ImageView fichaTable = (ImageView)findViewById(idImag[i][j]);
                fichaTable.setVisibility(View.INVISIBLE);
            }
        }

    }

    protected   int numRandom(int limSup, int limInf){
        int numAleatorio=(int)Math.floor(Math.random()*(limInf-limSup)+limSup);
        return numAleatorio;
    }

	protected	void firstTwoFile(){
        int xVal, yVal, eval, newVal, aux = 0;
        for(int i=0; i<2; i++){
                eval = 0;
            do{
                xVal = numRandom(0,3);
                yVal = numRandom(0,3);
                eval = valuePosRandom(xVal, yVal);
            }while(eval == 0);

            do{
                newVal = numRandom(2,4);
            }while(newVal%2!=0);

            table[xVal][yVal] = newVal;
            ImageView fichaTable = (ImageView)findViewById(idImag[xVal][yVal]);
            for (int j = 0; j < 24; j++) {
                if(idImagDir[j]==newVal){
                    aux = j;
                }
            }
            Drawable drawable = this.getResources().getDrawable(idImagDrawable[aux]);
            fichaTable.setImageDrawable(drawable);
            fichaTable.setVisibility(View.VISIBLE);
        }
    }

    protected	void fileRandomPlay(){
        int xVal, yVal, eval = 0, newVal,aux = 0,cont = 0,band = 0;
            do{
                xVal = numRandom(0,3);
                yVal = numRandom(0,3);
                eval = valuePosRandom(xVal, yVal);
                cont ++;
                if(cont == 5){
                    for (int i = 0; i < TAM; i++) {
                        for (int j = 0; j < TAM; j++) {
                            if(table[i][j] == 0){
                                xVal = i;
                                yVal = j;
                                eval = valuePosRandom(xVal, yVal);
                                band = 1;
                            }
                        }
                    }
                    if(eval==0){
                        Intent i = new Intent(ActivityGame.this, GameOver.class);
                        i.putExtra(getResources().getString(R.string.score),""+score);
                        startActivity(i);
                        finish();
                    }
                }
            }while(eval == 0);
            do{
                newVal = numRandom(2,4);
            }while(newVal%2!=0);
            table[xVal][yVal] =newVal;

            ImageView fichaTable = (ImageView)findViewById(idImag[xVal][yVal]);

            for (int j = 0; j < 24; j++) {
                if(idImagDir[j]==newVal){
                    aux = j;
                }
            }
            Drawable drawable = this.getResources().getDrawable(idImagDrawable[aux]);
            fichaTable.setImageDrawable(drawable);
            fichaTable.setVisibility(View.VISIBLE);

    }
    protected   int valuePosRandom(int x, int y){
        if(table[x][y] == 0){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int gameOver = 0;
        int moveN = 0, moveE = 0;
        boolean moveF = false;
        int hrz, vrt;

         switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                firstTouchX = event.getX();
                firstTouchY = event.getY();
                break;
             case MotionEvent.ACTION_UP:
                 finishTouchX = event.getX();
                 finishTouchY = event.getY();
                     hrz = Math.abs ((int) ( (firstTouchX) - (finishTouchX)));
                     vrt = Math.abs ((int) ((firstTouchY) - (finishTouchY)));

                     if(hrz>vrt){
                         if((firstTouchX - finishTouchX)>0){
                             moveN = leftMove();
                             moveE = leftMoveEat();
                             if(moveE == 2){
                                 leftMove();
                             }
                         }
                         else{
                             moveN = rightMove();
                             moveE = rightMoveEat();
                             if(moveE == 2){
                                 rightMove();
                             }
                         }
                     }else{
                         if((firstTouchY - finishTouchY)>0){
                             moveN = upMove();
                             moveE = upMoveEat();
                             if(moveE == 2){
                                 upMove();
                             }
                         }
                         else{
                             moveN = downMove();
                             moveE = downMoveEat();
                             if(moveE == 2){
                                 downMove();
                             }
                         }
                     }
                 break;
        }
   if(moveE == 2 || moveN == 1){
            moveF = true;
        }
        if(moveF == true) {
            fileRandomPlay();
            gameOver = checkGameOver();
            if (gameOver == 0) {
                Intent i = new Intent(ActivityGame.this, GameOver.class);
                i.putExtra(getResources().getString(R.string.score),""+score);
                startActivity(i);
                finish();
            }
        }
        return super.onTouchEvent(event);
    }


	protected	int upPossibleMove(){
            int j = 0, pos = 0;;
        do{
           int i = 1;
            do{
                pos = upPossible(i,j);
                if(pos == 1){
                    return 1;
                }
                i++;
            }while(i < TAM && pos == 0);
            j++;
        }while(j < TAM && pos == 0);
        return 0;
}
	protected	int downPossibleMove(){
        int j = 0, pos = 0;;
            do{
               int i = 0;
                do{
                    pos = downPossible(i,j);
                    if(pos == 1){
                        return 1;
                    }
                    i++;
                }while(i < TAM-1 && pos == 0);
                j++;
            }while(j < TAM && pos == 0);
            return 0;
    }
	protected	int leftPossibleMove(){
        int j = 1, pos = 0;
        do{
           int i = 0;
            do{
                pos = leftPossible(i,j);
                if(pos == 1){
                    return 1;
                }
                i++;
            }while(i < TAM && pos == 0);
            j++;
        }while(j < TAM && pos == 0);
        return 0;
    }
	protected	int rightPossibleMove(){
        int j = 0, pos = 0;
        do{
           int i = 0;
            do{
                pos = rightPossible(i,j);
                if(pos == 1){
                    return 1;
                }
                i++;
            }while(i < TAM && pos == 0);
            j++;
        }while(j < TAM-1 && pos == 0);
        return 0;
    }

	protected	int upPossible(int x, int y){
        if(table[x-1][y] == 0 && table[x][y] != 0){
            return 1;
        }
        return 0;
    }
	protected	int downPossible(int x, int y){
        if(table[x+1][y] == 0 && table[x][y] != 0){
            return 1;
        }
        return 0;
    }
    protected	int leftPossible(int x, int y){
        if(table[x][y-1] == 0 && table[x][y] != 0){
            return 1;
        }
        return 0;
    }
    protected	int rightPossible(int x, int y){
        if(table[x][y+1] == 0 && table[x][y] != 0){
            return 1;
        }
        return 0;
    }
    protected  void changeImg(int x, int y, int newVal){
        int aux = 0;
        if(newVal != 0) {
            for (int j = 0; j < 24; j++) {
                if(idImagDir[j]==newVal){
                    aux = j;
                }
            }
            ImageView fichaTable = (ImageView)findViewById(idImag[x][y]);
            Drawable drawable = this.getResources().getDrawable(idImagDrawable[aux]);
            fichaTable.setImageDrawable(drawable);
            fichaTable.setVisibility(View.VISIBLE);
        }
        else{
            ImageView fichaTable = (ImageView)findViewById(idImag[x][y]);
            fichaTable.setVisibility(View.INVISIBLE);
        }
    }
    protected	int upTable(int x, int y){
        if(table[x-1][y] == 0 && table[x][y] != 0){
            changeImg(x-1,y,table[x][y]);
            changeImg(x,y,0);
            table[x-1][y]= table[x][y];
            table[x][y] = 0;
            return 1;
        }
            return 0;
    }

    protected	int downTable(int x, int y){
        if(table[x+1][y] == 0 && table[x][y] != 0){
            changeImg(x+1,y,table[x][y]);
            changeImg(x,y,0);
            table[x+1][y]= table[x][y];
            table[x][y] =0;
            return 1;
        }
            return 0;
    }
	protected	int leftTable(int x, int y){
        if(table[x][y-1] == 0 && table[x][y] != 0){
            changeImg(x,y-1,table[x][y]);
            changeImg(x,y,0);
            table[x][y-1]=table[x][y];
            table[x][y]=0;
            return 1;
        }
        return 0;
    }
	protected	int rightTable(int x, int y){
        if(table[x][y+1] == 0 && table[x][y] != 0){
            changeImg(x,y+1,table[x][y]);
            changeImg(x,y,0);
            table[x][y+1]=table[x][y];
            table[x][y]=0;
            return 1;
        }
            return 0;
    }


	protected	int upEat(int x, int y){
       if(table[x-1][y] == table[x][y] && table[x][y] != 0){
           changeImg(x-1,y,table[x][y]*2);
           changeImg(x,y,0);
            table[x-1][y]=table[x][y]*2;
            score += table[x][y]*2;
           TextView cantScore  = (TextView)findViewById(R.id.cantScore);
           cantScore.setText(""+score);
            table[x][y]=0;
            return 1;
        }
            return 0;
    }
	protected	int downEat(int x, int y){
       if(table[x-1][y] == table[x][y] && table[x][y] != 0){
           changeImg(x-1,y,table[x][y]*2);
           changeImg(x,y,0);
            table[x-1][y]=table[x][y]*2;
            score += table[x][y]*2;
           TextView cantScore  = (TextView)findViewById(R.id.cantScore);
           cantScore.setText(""+score);
            table[x][y]=0;
            return 1;
        }
            return 0;
    }
	protected	int leftEat(int x, int y){
       if(table[x][y-1] == table[x][y] && table[x][y] != 0){
           changeImg(x,y-1,table[x][y]*2);
           changeImg(x,y,0);
            table[x][y-1]=table[x][y]*2;
            score += table[x][y]*2;
           TextView cantScore  = (TextView)findViewById(R.id.cantScore);
           cantScore.setText(""+score);
            table[x][y]=0;
            return 1;
        }
            return 0;
    }
	protected	int rightEat(int x, int y){
       if(table[x][y-1] == table[x][y] && table[x][y] != 0){
           changeImg(x,y-1,table[x][y]*2);
           changeImg(x,y,0);
            table[x][y-1]=table[x][y]*2;
            score += table[x][y]*2;
           TextView cantScore  = (TextView)findViewById(R.id.cantScore);
           cantScore.setText(""+score);
            table[x][y]=0;
            return 1;
        }
            return 0;
    }

	protected	int upMove(){
        int pos;
        int eat = 0, aux;
        do{
            pos = 0;
            for(int i= 1; i<TAM; i++){
                for(int j=0; j<TAM; j++){
                    aux = upTable(i,j);
                    if(aux == 1){
                        eat = 1;
                    }
                }
            }
            pos = upPossibleMove();
        }while(pos == 1);
        return eat;
    }
	protected	int downMove(){
        int pos;
        int eat = 0, aux;
        do{
            pos = 0;
            for(int i= 0; i<TAM-1; i++){
                for(int j=0; j<TAM; j++){
                    aux = downTable(i,j);
                    if(aux == 1){
                        eat = 1;
                    }
                }
            }
            pos = downPossibleMove();
        }while(pos == 1);
        return eat;
    }
	protected	int leftMove(){
        int pos;
        int eat = 0, aux;
        do{
            pos = 0;
            for(int i= 0; i<TAM; i++){
                for(int j=1; j<TAM; j++){
                    aux = leftTable(i,j);
                    if(aux == 1){
                        eat = 1;
                    }
                }
            }
            pos = leftPossibleMove();
        }while(pos == 1);
        return eat;
    }
	protected	int rightMove(){
       int pos;
        int eat = 0, aux;
        do{
            pos = 0;
            for(int i= 0; i<TAM; i++){
                for(int j=0; j<TAM-1; j++){
                    aux = rightTable(i,j);
                    if(aux == 1){
                        eat = 1;
                    }
                }
            }
            pos = rightPossibleMove();
        }while(pos == 1);
        return eat;
    }


	protected	int upMoveEat(){
        int eat = 0, aux;
       for(int i= 1; i<TAM; i++){
            for(int j=0; j<TAM; j++){
               aux = upEat(i,j);
               if(aux == 1){
                    eat = 2;
                }
            }
        }
        return eat;
    }
	protected	int downMoveEat(){
        int eat = 0, aux;
        for(int i= TAM-1; i>0; i--){
            for(int j=TAM-1; j>=0; j--){
                aux = downEat(i,j);
                if(aux == 1){
                    eat = 2;
                }
            }
        }
        return eat;
    }

	protected	int leftMoveEat(){
        int eat = 0, aux;
       for(int i= 0; i<TAM; i++){
            for(int j=1; j<TAM; j++){
                aux = leftEat(i,j);
                if(aux == 1){
                    eat = 2;
                }
            }
        }
        return eat;
    }
	protected	int rightMoveEat(){
        int eat = 0, aux;
        for(int i= TAM-1; i>=0; i--){
            for(int j=TAM-1; j>0; j--){
                aux = rightEat(i,j);
                if(aux == 1){
                    eat = 2;
                }
            }
        }
        return eat;
    }
	protected	int upPossibleMoveEat(){
        int eat = 0, aux;
       for(int i= 1; i<TAM; i++){
            for(int j=0; j<TAM; j++){
               aux = upPossibleEat(i,j);
               if(aux == 1){
                    eat = 2;
                }
            }
        }
        return eat;
    }
	protected	int downPossibleMoveEat(){
       int eat = 0, aux;
        for(int i= TAM-1; i>0; i--){
            for(int j=TAM-1; j>=0; j--){
                aux = downPossibleEat(i,j);
                if(aux == 1){
                    eat = 2;
                }
            }
        }
        return eat;
    }
	protected	int leftPossibleMoveEat(){
        int eat = 0, aux;
       for(int i= 0; i<TAM; i++){
            for(int j=1; j<TAM; j++){
                aux = leftPossibleEat(i,j);
                if(aux == 1){
                    eat = 2;
                }
            }
        }
        return eat;
    }
	protected	int rightPossibleMoveEat(){
       int eat = 0, aux;
        for(int i= TAM-1; i>=0; i--){
            for(int j=TAM-1; j>0; j--){
                aux = rightPossibleEat(i,j);
                if(aux == 1){
                    eat = 2;
                }
            }
        }
        return eat;
    }
    protected	int upPossibleEat(int x, int y){
        if(table[x-1][y] == table[x][y] && table[x][y] != 0){
            return 1;
        }
        return 0;
    }
    protected	int downPossibleEat(int x, int y){
        if(table[x-1][y] == table[x][y] && table[x][y] != 0){
            return 1;
        }
        return 0;
    }
    protected	int leftPossibleEat(int x, int y){
        if(table[x][y-1] == table[x][y] && table[x][y] != 0){
            return 1;
        }
        return 0;
    }
    protected	int rightPossibleEat(int x, int y){
        if(table[x][y-1] == table[x][y] && table[x][y] != 0){
            return 1;
        }
        return 0;
    }
	protected	int checkGameOver(){
        int nGameOver = 0;
         for(int i= 0; i<TAM; i++){
            for(int j=0; j<TAM; j++){
                if(table[i][j] == 0){
                    nGameOver = 1;
                }
                if(nGameOver==0){
                    nGameOver = upPossibleMoveEat();
                }
                if(nGameOver==0){
                    nGameOver = downPossibleMoveEat();
                }
                if(nGameOver==0){
                    nGameOver = leftPossibleMoveEat();
                }
                if(nGameOver==0){
                    nGameOver = rightPossibleMoveEat();
                }
            }
        }
        return nGameOver;
    }


}
