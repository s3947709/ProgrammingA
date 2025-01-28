package Final_Test;
import javax.swing.*;
import java.awt.*;

public class Q18 extends JFrame{
    public Q18(){

        JTextField destinationField, durationField;

        JFrame frame = new JFrame("Where would you like to go");

        frame.setSize(450,300);
        frame.setLayout(new FlowLayout());

        JPanel panel = new JPanel(new GridLayout(2,2,5,5));


        JLabel label1 = new JLabel("Enter Destination");
        destinationField = new JTextField(20);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel label2 = new JLabel("Enter Duration in days");
        durationField = new JTextField(20);
        label2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JTextArea printBox = new JTextArea(7,40);
        printBox.setEditable(false);

        JButton showButton = new JButton("SHOW info");
        JButton clearButton = new JButton("CLEAR");
        


        panel.add(label1);
        panel.add(destinationField);
        panel.add(label2);
        panel.add(durationField);

        frame.add(panel);
        frame.add(printBox);
        frame.add(showButton, BorderLayout.SOUTH);
        frame.add(clearButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Q18();
    }
}
