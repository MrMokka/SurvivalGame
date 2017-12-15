package Objects;


import java.awt.*;

public class Field {
    
    private int xPos, yPos;
    private int xSize, ySize;
    private Color color = new Color(120, 120, 120);
    
    
    
    
    
    public Field(){
    
    }
    
    public void setPos(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public void setSize(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
    }
    
    public int getPosX(){ return xPos; }
    public int getPosY(){ return yPos; }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.drawRect(xPos, yPos, xSize, ySize);
    }
    
    
    
}
