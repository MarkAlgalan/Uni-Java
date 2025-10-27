package escuela.rectanglearea;
import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RectangleArea {
    JTextField dato1, dato2;
    public RectangleArea(){
        JFrame ventana = new JFrame("Caja de algo wuuu");
        dato1=new JTextField("Juan",50);
        dato1.setBackground(new Color(255,255,51));
        dato1.setForeground(new java.awt.Color(102,102,255));
        dato2 = new JTextField("Es gei",21);
        dato2.setBackground(new Color(200,200,123));
        dato2.setForeground(new Color(3,0,70));
        ventana.setLayout(new FlowLayout());
        ventana.setSize(3000, 700);
        ventana.setVisible(true);
        ventana.add(dato1);
        ventana.add(dato2);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        RectangleArea v2 = new RectangleArea();
        JFrame v;
        v = new JFrame("Juan ya declaratele a sol");
        v.setVisible(true);
        v.setSize(500, 200);
        v.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
