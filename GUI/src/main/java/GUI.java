import javax.swing.JFrame;
import java.awt.*;
public class GUI extends JFrame{
    private static final int HEIGHT = 300;
    private static final int WIDTH = 700;
    public GUI(){
        setTitle("CálculaÁrea de un Rectángulo");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[]args) {  
        GUI v1 = new GUI(); 
    }
}