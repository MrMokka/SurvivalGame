package Objects;


import java.awt.*;

public class Building {
    
    private int xPos, yPos;
    private int xSize, ySize;
    private Color color = Color.black;
    
    
    
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(xPos, yPos, xSize, ySize);
    }
    
    
}
