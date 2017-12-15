import Objects.Field;
import Objects.Player;
import Screen.Frame;
import Screen.Panel;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


public class Master {
    
    
    private Frame frame;
    private Panel gamePanel;
    private Player player;
    
    private int gridSize = 50;
    private int gameSize = 800;
    
    private KeyListener playerMove = new KeyListener() {
        @Override public void keyTyped(KeyEvent e){ }
        @Override public void keyPressed(KeyEvent e){
            System.out.println("Pressed: " + e.getKeyChar());
            if(e.getKeyCode() == KeyEvent.VK_W)
                player.setUp(true);
            if(e.getKeyCode() == KeyEvent.VK_S)
                player.setDown(true);
            if(e.getKeyCode() == KeyEvent.VK_A)
                player.setLeft(true);
            if(e.getKeyCode() == KeyEvent.VK_D)
                player.setRight(true);
        }
        @Override public void keyReleased(KeyEvent e){
            //System.out.println("Released: " + e.getKeyChar());
            if(e.getKeyCode() == KeyEvent.VK_W)
                player.setUp(false);
            if(e.getKeyCode() == KeyEvent.VK_S)
                player.setDown(false);
            if(e.getKeyCode() == KeyEvent.VK_A)
                player.setLeft(false);
            if(e.getKeyCode() == KeyEvent.VK_D)
                player.setRight(false);
        }
    };
    
    private ArrayList<Field> fields = new ArrayList<>();
    
    
    public Master(){
    
        
        
        
        
        frame = new Frame(1200, 1000);
        gamePanel = new Panel();
        
        frame.add(gamePanel);
        
        gamePanel.setBackground(Color.lightGray);
        gamePanel.setBounds(40, 30, gameSize + 1, gameSize + 1);
        gamePanel.setLayout(null);
        
        
        createGrid();
        createPlayer();
        
        gamePanel.addKeyListener(playerMove);
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
        
        gamePanel.repaint();
        
        //gameloop();
    }
    
    
    private void gameloop(){
        
        while(true){
            player.move();
            gamePanel.repaint();
        }
        
    }
    
    
    private void createGrid(){
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                
                Field temp = new Field();
                temp.setPos(i * gameSize / gridSize, j * gameSize / gridSize);
                temp.setSize(gameSize / gridSize, gameSize / gridSize);
                fields.add(temp);
                gamePanel.addDrawField(temp);
                
            }
        }
    }
    
    
    private void createPlayer(){
        Random random = new Random();
        int x = fields.get(random.nextInt(gridSize)).getPosX();
        int y = fields.get(random.nextInt(gridSize)).getPosY();
    
        player = new Player();
        player.setPos(x, y);
        int size = (int) Math.floor((gameSize / gridSize) / 1.5f + 0.5f);
        player.setSize(size, size);
        gamePanel.addDrawEntity(player);
        
    }
    
    
    
    
    
    
    
}
