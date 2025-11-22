package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    public SimpleGUI() {
        final JButton saveButton = new JButton("Save");
        final JTextArea inputText = new JTextArea();
        this.frame.setLayout(new BorderLayout());
        this.frame.add(saveButton, BorderLayout.SOUTH);
        this.frame.add(inputText, BorderLayout.CENTER);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeStringToFile(inputText.getText());
                } catch (IOException e1) {
                    // This could be a JDIalog showing the error.
                    System.out.println(e1.getStackTrace()); //NOMPD
                }
            }
        });
    }

    private void display() {
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new SimpleGUI().display();
    }
}
