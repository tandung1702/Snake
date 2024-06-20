/*
 * Nguyễn Tấn Dũng
 * ITITIU21185
 * Purpose: The code is designed to implement the game Snake
 */
package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class Main  extends JFrame{
    
    GameScreen game;
    
    public Main (){
        setSize(650,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        game = new GameScreen();
        add(game);
        
        this.addKeyListener(new move ());
        setVisible(true);
          
        
    }

    
    public static void main(String[] args) {
        Main f = new Main();
        
    }
    private class move implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            
            if(e.getKeyCode()== KeyEvent.VK_SPACE){
                    GameScreen.isPlaying=!GameScreen.isPlaying;
                    if(GameScreen.isGameEnd) {
                        GameScreen.isGameEnd=false;
                        game.snake.resetGame();
                        
                    }
                 
            }
            
            if(e.getKeyCode()== KeyEvent.VK_UP){
                    game.snake.setVector(Snake.GoUP);
            }
            if(e.getKeyCode()== KeyEvent.VK_DOWN){
                    game.snake.setVector(Snake.GoDown);
            }
            if(e.getKeyCode()== KeyEvent.VK_LEFT){
                    game.snake.setVector(Snake.GoLeft);
            }
            if(e.getKeyCode()== KeyEvent.VK_RIGHT){
                    game.snake.setVector(Snake.GoRight);
            }
        
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    
    
    }
}
