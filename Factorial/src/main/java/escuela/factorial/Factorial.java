package escuela.factorial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Factorial extends JFrame implements ActionListener {
    JButton botonIngresoRespuesta;
    FlowLayout miFlowLayout;
    javax.swing.JLabel respuesta = new javax.swing.JLabel();
    JTextField numero = new JTextField(24);
    public Factorial(){
        miFlowLayout = new FlowLayout(FlowLayout.CENTER,30,30);
       
        botonIngresoRespuesta = new JButton("Calcular Factorial");
        numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void tecleo(java.awt.event.KeyEvent event){
                soloNumeros(event);
            }
        });
        
        numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        
        
        
        setLayout(miFlowLayout);
        
        add(numero);
        add(botonIngresoRespuesta);
        
        botonIngresoRespuesta.addActionListener(this);
       
        initPantalla();
    }
    private void initPantalla(){
        setTitle("Ingrese un numero");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Factorial();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        long t = Integer.parseInt(numero.getText());
        JDialog x = new JDialog();
        if(t>=0){
            respuesta.setText(factoria(t)+"");
        }else{
            respuesta.setText("Solo numeros positivos");
        }
        
        x.setSize(500,200);
        x.setLayout(miFlowLayout);
        x.add(respuesta);
        x.setVisible(true);
        x.setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        validate();
    }
    public static long factoria(long y){
        if(y==1){
           return y; 
        }if(y==0){
            return 1;
        }else{
            return y*factoria(y-1);
        }

    }
    private void soloNumeros(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if(c<'0'||c>'9')evt.consume();
    }
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    } 
}
