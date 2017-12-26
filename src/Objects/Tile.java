package Objects;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tile {
    
    private int xPos, yPos;
    private int xSize, ySize;
    private Color color = new Color(120, 120, 120);
    private Image baseTile;
    
    
    
    
    public Tile(){
        
        try {
            baseTile = ImageIO.read(new File("/res/tile_base.png"));
        }
        catch (IOException e) {}
        
        
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
        g.drawImage(baseTile, xPos, yPos, 16, 16, null);
        //g.drawRect(xPos, yPos, xSize, ySize);
    }
    
    
    
}
