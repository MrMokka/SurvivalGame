import Objects.Entity;

import javax.swing.*;
import java.util.*;

public class GameLoop {
    
    public static boolean gameRunning = false;
    
    private ArrayList<Entity> entities = new ArrayList<>();
    
    private ArrayList<JComponent> paintComponent = new ArrayList<>();
    
    private long lastFpsTime;
    private int fps;
    
    private Thread loop = new Thread(){
        public void run(){
            gameLoop();
        }
    };
    
    public GameLoop(){
    
    }
    
    
    public void addEntity(Entity ent){ entities.add(ent); }
    public void addPaintComp(JComponent comp){ paintComponent.add(comp); }
    
    
    public void startGameLoop(){
        gameRunning = true;
        loop.start();
    }
    
    public void stopGameLoop(){
        gameRunning = false;
    }
    
    private void gameLoop(){
        
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    
    
        // keep looping round til the game ends
        while (gameRunning)
        {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);
        
            // update the frame counter
            lastFpsTime += updateLength;
            fps++;
        
            // update our FPS counter if a second has passed since
            // we last recorded
            if (lastFpsTime >= 1000000000)
            {
                System.out.println("(FPS: "+fps+")");
                lastFpsTime = 0;
                fps = 0;
            }
        
            // update the game logic
            doGameUpdates(delta);
        
            // draw everyting
            render();
        
            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try{
                Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
            } catch(Exception e){
            
            }
        }
        
    }
    
    private void doGameUpdates(double delta){
        for (int i = 0; i < entities.size(); i++)
        {
            entities.get(i).tick(delta);
            
        }
    }
    
    private void render(){
        for(int i = 0; i < paintComponent.size(); i++){
            paintComponent.get(i).repaint();
        }
    }
    
}
