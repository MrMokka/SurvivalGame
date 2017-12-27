import Objects.Tile;
import Objects.Player;
import Screen.Frame;
import Screen.Panel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;


public class Master {
    
    
    private Frame frame;
    private Panel gamePanel;
    private Player player;
    private GameLoop gameLoop = new GameLoop();
    
    private int gridSize = 50;
    private int gameSize = 800;
    
    private KeyListener playerMove = new KeyListener() {
        @Override public void keyTyped(KeyEvent e){ }
        @Override public void keyPressed(KeyEvent e){
            //System.out.println("Pressed: " + e.getKeyChar());
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
    private MouseListener mouseClick = new MouseListener() {
        @Override public void mouseClicked(MouseEvent e){}
        @Override public void mousePressed(MouseEvent e){}
        @Override public void mouseEntered(MouseEvent e){}
        @Override public void mouseExited(MouseEvent e){}
        @Override
        public void mouseReleased(MouseEvent e){
        
        }
    };
    
    private ArrayList<Tile> tiles = new ArrayList<>();
    
    
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
        gamePanel.addMouseListener(mouseClick);
        
        gamePanel.repaint();
        
        gameLoop.addEntity(player);
        gameLoop.addPaintComp(gamePanel);
        
        gameLoop.startGameLoop();
        
    }
    
    
    private void createGrid(){
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                
                Tile temp = new Tile();
                temp.setPos(i * gameSize / gridSize, j * gameSize / gridSize);
                temp.setSize(gameSize / gridSize, gameSize / gridSize);
                tiles.add(temp);
                gamePanel.addDrawField(temp);
                
            }
        }
    }
    
    
    private void createPlayer(){
        Random random = new Random();
        int size = (int) Math.floor((gameSize / gridSize) / 1.5f + 0.5f);
        int x = gameSize / 2 + size;
        int y = gameSize / 2 + size;
    
        player = new Player();
        player.setPos(x, y);
        
        player.setSize(size, size);
        gamePanel.addDrawEntity(player);
        
    }
    
    
    
    
    
    
    
}
