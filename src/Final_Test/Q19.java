package Final_Test;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q19 extends JFrame{

    public Q19(){

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

        JTextArea printBox = new JTextArea(10,40);
        printBox.setEditable(false);

        JButton showButton = new JButton("SHOW info");
        JButton clearButton = new JButton("CLEAR");
        
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ){
                String destination = destinationField.getText();
                String duration = durationField.getText();

                if (!destination.isEmpty() && !duration.isEmpty()){
                    printBox.setText("Destination: " + destination + " \nDuration: " + duration + " days");
                }
                else {
                    printBox.setText("Please fill both fields");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
            destinationField.setText("");
            durationField.setText("");
            printBox.setText("");
           } 
        });


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
        new Q19();
    }

}