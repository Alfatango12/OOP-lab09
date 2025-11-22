package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /**
     * Constructor method.
     * It creates the whole gui.
     */
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
                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "I/O Exception", JOptionPane.ERROR_MESSAGE);
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

    /**
     * Main function. It calls the method that starts the gui.
     * 
     * @param args main arguments passed by command line.
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
