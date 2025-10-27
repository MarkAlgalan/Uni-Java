package escuela.separabotones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SeparaBotones extends JFrame implements ActionListener {
    JButton boton1, boton2, boton3, boton4, boton5;
    FlowLayout miFlowLayout;
    public SeparaBotones(){
        miFlowLayout = new FlowLayout(FlowLayout.CENTER,3,3);
        setLayout(miFlowLayout);
        boton1 = new JButton("Diana");
        boton2 = new JButton("Juan");
        boton3 = new JButton("David");
        boton4 = new JButton("Davicha");
        boton5 = new JButton("Betox");
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);
        initPantalla();
    }
    private void initPantalla(){
        setTitle("Amigos y Novia");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SeparaBotones();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        miFlowLayout.setHgap(miFlowLayout.getHgap()+5);
        miFlowLayout.setVgap(miFlowLayout.getVgap()+5);
        setLayout(miFlowLayout);
        validate();
    }
}
