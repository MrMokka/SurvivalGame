package Screen;

import Objects.Building;
import Objects.Entity;
import Objects.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Panel extends JPanel {
    
    
    private ArrayList<Tile> drawTiles = new ArrayList<>();
    private ArrayList<Entity> drawEntity = new ArrayList<>();
    private ArrayList<Building> drawBuildings = new ArrayList<>();
    
    private Image baseTile;
    
    public Panel(){
        setLayout(null);
        setVisible(true);
    
        try {
            baseTile = ImageIO.read(new File("/res/tile_base.png"));
            System.out.println("got image");
        }
        catch (IOException e) {
            System.out.println("cant get file");
        }
        
    }
    
    public void addDrawField(Tile obj){
        drawTiles.add(obj);
    }
    
    public void addDrawEntity(Entity obj){
        drawEntity.add(obj);
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    
        for(int i = 0; i < drawTiles.size(); i++){
            drawTiles.get(i).draw(g);
        }
        
        for(int i = 0; i < drawEntity.size(); i++){
            drawEntity.get(i).draw(g);
            //System.out.println("draw entity");
        }
        
        for(int i = 0; i < drawBuildings.size(); i++){
            drawBuildings.get(i).draw(g);
        }
    
        g.drawImage(baseTile, 10, 10, 30, 30, null);
        
    }
    
    
}
