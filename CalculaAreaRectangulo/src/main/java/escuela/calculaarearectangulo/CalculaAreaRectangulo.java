package escuela.calculaarearectangulo;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CalculaAreaRectangulo extends JFrame {
    private JLabel lengthLabel, widthLabel, areaLabel;
    private JTextField lengthText, widthText, areaText;
    private JButton calculateButton, exitButton;
    private static final int HEIGHT = 400;
    private static final int WIDTH= 300;
    private CalculateButtonHandler calculateButtonHandler;
    private ExitButtonHandler exitButtonHandler;
    public CalculaAreaRectangulo(){
        lengthLabel = new JLabel("Teclea la longitud");
        widthLabel = new JLabel("Teclea el ancho");
        areaLabel= new JLabel("El área es: ", SwingConstants.RIGHT);
        lengthText = new JTextField();
        widthText = new JTextField();
        areaText = new JTextField();
        calculateButton = new JButton("Cual es el area");
        calculateButtonHandler = new CalculateButtonHandler();
        calculateButton.addActionListener(calculateButtonHandler);
        
        exitButton= new JButton("Close");
        exitButtonHandler = new ExitButtonHandler();
        exitButton.addActionListener(exitButtonHandler);
        setTitle("Áre de un Rectángulo");
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4,2));
        pane.add(lengthLabel);
        pane.add(lengthText);
        pane.add(widthLabel);
        pane.add(widthText);
        pane.add(areaLabel);
        pane.add(areaText);
        pane.add(calculateButton);
        pane.add(exitButton);
        setSize(HEIGHT, WIDTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private class CalculateButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double width, length, area;
            length = Double.parseDouble(lengthText.getText());
            width = Double.parseDouble(widthText.getText());
            area=length*width;
            areaText.setText(""+area);
            
        }
    }
    public class ExitButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        CalculaAreaRectangulo rectObj = new CalculaAreaRectangulo();
    }
}
