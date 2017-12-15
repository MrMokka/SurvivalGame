package Screen;

import javax.swing.*;

public class Frame extends JFrame {
    
    
    
    public Frame(int width, int height){
    
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setLocation(300, 200);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
    }
    
    
}
