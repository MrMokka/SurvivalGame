package Objects;

import java.awt.*;

public class Player extends Entity {
    
    
    private int xPos, yPos;
    private int xSize = 10, ySize = 10;
    private Color color = Color.green;
    private float moveSpeed = 2.5f;
    
    private boolean moveUp, moveDown, moveLeft, moveRight;
    
    public Player(){
    
    }
    
    public void setPos(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public void setSize(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
    }
    
    public void setUp(boolean res){ moveUp = res; }
    public void setDown(boolean res){ moveDown = res; }
    public void setLeft(boolean res){ moveLeft = res; }
    public void setRight(boolean res){ moveRight = res; }
    
    
    
    
    public void tick(double delta){
        move(delta);
    }
    
    public void move(double delta){
        int deltaX = 0, deltaY = 0;
        if(moveUp)
            deltaY--;
        if(moveDown)
            deltaY++;
        if(moveLeft)
            deltaX--;
        if(moveRight)
            deltaX++;
        
        double moveX = deltaX * moveSpeed * delta;
        double moveY = deltaY * moveSpeed * delta;
        
        xPos += (int) moveX;
        yPos += (int) moveY;
    
        //System.out.println(xPos + ":" + yPos);
        
    }
    
    
    
    public void draw(Graphics g){
        //System.out.println("drawing player");
        g.setColor(color);
        g.fillRect(xPos, yPos, xSize, ySize);
    }
    
    
}
