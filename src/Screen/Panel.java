package Screen;

import Objects.Building;
import Objects.Entity;
import Objects.Field;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    
    
    private ArrayList<Field> drawFields = new ArrayList<>();
    private ArrayList<Entity> drawEntity = new ArrayList<>();
    private ArrayList<Building> drawBuildings = new ArrayList<>();
    
    
    public Panel(){
        setLayout(null);
        setVisible(true);
        
    }
    
    public void addDrawField(Field obj){
        drawFields.add(obj);
    }
    
    public void addDrawEntity(Entity obj){
        drawEntity.add(obj);
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    
        for(int i = 0; i < drawEntity.size(); i++){
            drawEntity.get(i).draw(g);
            System.out.println("draw entity");
        }
        for(int i = 0; i < drawFields.size(); i++){
            drawFields.get(i).draw(g);
        }
        
        for(int i = 0; i < drawBuildings.size(); i++){
            drawBuildings.get(i).draw(g);
        }
        
    }
    
    
}
