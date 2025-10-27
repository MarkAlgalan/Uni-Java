package com.mycompany.bordes;

//importamos toda la utilidad referente a los AWT y java Swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Bordes extends JPanel { //la clase va a heredar propiedades de JPanel

    static JPanel creaBorde(Border b){ // metodo estatico para crear un borde
        JPanel panel = new JPanel(); // instanciamos un objeto tipo JPanel
        String str = b.getClass().toString(); // creamos una variable tipo string que va a transformar a string al tipo de dato border
        
        // ajustamos parametros para poder establecer el formato de nuestro borde
        str = str.substring(str.lastIndexOf('.') + 1);
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(str,JLabel.CENTER),BorderLayout.CENTER);
        panel.setBorder(b); // simplemente establecemos nuestro tipo de borde con el que deseamos
        
        return(panel); // regresa nuestro tipo de dato panel
    }
    
    public Bordes(){ // creamos la clase que nos va a permitir agregar todos los tipos de bordes para poder verlos de ejemplo
        setLayout(new GridLayout(2,4));
        add(creaBorde(new TitledBorder("Titulo")));
        add(creaBorde(new EtchedBorder()));
        add(creaBorde(new LineBorder(Color.blue)));
        add(creaBorde(new MatteBorder(5,5,30,30,Color.green)));
        add(creaBorde(new BevelBorder(BevelBorder.RAISED)));
        add(creaBorde(new SoftBevelBorder(BevelBorder.LOWERED)));
        add(creaBorde(new CompoundBorder(new EtchedBorder(),new LineBorder(Color.red))));
    }
    public static void main(String[] args) { // metodo main
        JFrame frame = new JFrame("Tutorial de Java, Swing"); // creamos nuestro JFrame con el titulo "Tutorial de Java, Swing"
        frame.addWindowListener(new WindowAdapter(){ // nos permite reaccionar a eventos
        public void windowClosing(WindowEvent evt){ // el evento de cerrar la ventana se define para poder salir
            System.exit(0); // cerramos el sistema completo
        }
        });
        frame.getContentPane().add(new Bordes(),BorderLayout.CENTER); // implementamos nuestros bordes definidos en el metodo Borde()
        frame.setSize(500,300); // definimos sus dimensiones
        frame.setVisible(true); // lo hacemos visible, de otra manera no se va a ver 
            
        }
       }


