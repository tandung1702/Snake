/*
 * Nguyễn Tấn Dũng
 * ITITIU21185
 * Purpose: This code implements the core mechanics of a Snake game
 *          including movement, collision detection, food spawning, rendering the snake on the screen,
 *          and snake speed increases with each level.
 */
package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class Snake {
    int length = 3;
    int []x;
    int []y;
    
    public static int GoUP = 1;
    public static int GoDown = -1;
    public static int GoRight = 2;
    public static int GoLeft = -2;
    
    int vector = Snake.GoDown;
    
    long t1 = 0;
    
    int speed = 200;
    
    int maxlength= 5;
    
    public Snake(){
        x = new int [20];
        y = new int [20];
        
        x[0] = 5;
        y[0] = 4;
        x[1] = 5;
        y[1] = 3;
        x[2] = 5;
        y[2] = 2;
        
     }
    
    public void resetGame(){
        length = 3;
        x = new int [100];
        y = new int [100];
        
        x[0] = 5;
        y[0] = 4;
        x[1] = 5;
        y[1] = 3;
        x[2] = 5;
        y[2] = 2;
        
        vector = Snake.GoDown;
        
    }
    //Avoid the situation where you can't move down the road
    public void setVector (int v){
        if(vector != -v)
        vector = v;
    }
    //Random food spawn location
    public Point food () {
        Random r = new Random();
        int x = r.nextInt(19);
        int y = r.nextInt(19);
        return new Point (x,y);
    }
    //Speed of snake through the level
    public int getSpeed(){
        for(int i = 0; i< GameScreen.Level; i++)
            speed*=0.8;
            return speed;
    }
    
    public void update (){
        
        if(length == maxlength){ 
            GameScreen.isPlaying=false;
            resetGame();
            GameScreen.Level++;
            maxlength +=5;
            speed= getSpeed();
            
        }
      
        
        
        //The snake's head moves into the body => end game
        for(int i = 1;i< length; i++){
            if(x[0]== x[i] && y[0] == y[i]){
              
           GameScreen.isPlaying=false;
           GameScreen.isGameEnd=true;
            
            GameScreen.Level = 1;
            GameScreen.point = 0;
            }
        }
         if(System.currentTimeMillis()-t1>speed){
            
            if(GameScreen.bg[x[0]][y[0]]==2){
                length++;
                GameScreen.bg[x[0]][y[0]]=0;
                GameScreen.bg[food().x][food().y]=2;
                GameScreen.point+=100;
            }
           //Connect the snake's head to the body
            for(int i=length-1;i>0;i--){
                x[i]=x[i-1];
                y[i]=y[i-1];
            }
            
            if(vector == Snake.GoUP) y[0]--;
            if(vector == Snake.GoDown) y[0]++;
            if(vector == Snake.GoLeft) x[0]--;
            if(vector == Snake.GoRight) x[0]++;

             
            //Snake goes through the wall
            if(x[0]<0) x[0]=19;
            if(x[0]>19) x[0]=0;
            if(y[0]<0) y[0]=19;
            if(y[0]>19) y[0]=0;

            t1 = System.currentTimeMillis();
        }
            
           
        
        
    }
    //Draw snake
     public void drawSnake (Graphics g) {
         g.setColor(Color.red);
         for(int i=0;i<length;i++)
                g.fillRect(x[i]*20+1, y[i]*20+1, 18, 18);
     
     }
}
