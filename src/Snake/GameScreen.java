/*
 * Nguyễn Tấn Dũng
 * ITITIU21185
 * Purpose:The code is designed for the display of the game 
 */
package Snake;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class GameScreen extends JPanel implements Runnable{
    static int [][] bg = new int [20][20];
    
    static boolean  isPlaying = false;
    static boolean isGameEnd = false;
    
    static int Level = 1;
    
    
    
    Snake snake;
    
    Thread thread;
    static int point =0;
  
    public GameScreen (){
        
        snake = new Snake();
        
        bg [13][17] = 2;
        
        thread = new Thread(this);
        thread.start();
        
    
    }
    
    public void run(){
        long t = 0;
        
        while(true){
            
           if(isPlaying){
                if(System.currentTimeMillis()-t>200){
                    
                    t=System.currentTimeMillis();
                }
                snake.update();
            }
            repaint();
           try {
                sleep(20);
            } catch (InterruptedException ex) {}
             
        }
    
    }
    //Draw the environment for Snake
    public void paintBg(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0, 400+200, 400);
        for(int i=0;i<20;i++)
            for(int j=0;j<20;j++){
                if(bg[i][j] == 2){
                    g.setColor(Color.blue);
                    g.fillRect(i*20+1, j*20+1, 18, 18);   
                }
       
            }
    }
    private void background (Graphics g){
           g.setColor(Color.red);
           g.drawRect(0, 0, 400+200, 400);
           g.drawRect(1, 1, 400, 400);
           g.drawRect(2, 2, 400, 400);
           
    
    }
    public void paint (Graphics g){
        paintBg(g);
        snake.drawSnake(g);
        background(g);
        if(!isPlaying){
            g.setColor(Color.white);
            g.setFont(g.getFont().deriveFont(18.0f));
            g.drawString("'SPACE' TO PLAY!", 130, 200);
        
        }
        if(isGameEnd){
            g.setColor(Color.white);
            g.setFont(g.getFont().deriveFont(20.0f));
            g.drawString("GAME OVER!", 100, 250);
         }
        

        g.setColor(Color.green);
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString("FINAL PROJECT", 430, 130);

        g.setColor(Color.green);
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString("DSA", 480, 150);
        
        g.setColor(Color.red);
        g.setFont(g.getFont().deriveFont(20.0f));
        g.drawString("LEVEL : "+Level , 450, 200);
        
        g.setColor(Color.MAGENTA);
        g.setFont(g.getFont().deriveFont(18.0f));
        g.drawString("POINT : "+point , 450, 250);
    
    }
    
}
