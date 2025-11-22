package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /**
     * Constructor that creates all the UI elements.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel mainPanel = new JPanel();
        final JPanel fileChooserPanel = new JPanel();
        final JButton saveButton = new JButton("Save");
        final JTextArea inputText = new JTextArea();
        final JTextField filePath = new JTextField();
        final JButton browseButton = new JButton("Browse..."); 
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(saveButton, BorderLayout.SOUTH);
        mainPanel.add(inputText, BorderLayout.CENTER);
        mainPanel.add(fileChooserPanel, BorderLayout.NORTH);
        mainPanel.setVisible(true);
        fileChooserPanel.setLayout(new BorderLayout());
        fileChooserPanel.add(filePath, BorderLayout.CENTER);
        fileChooserPanel.add(browseButton, BorderLayout.LINE_END);
        fileChooserPanel.setVisible(true);
        filePath.setEditable(false);
        filePath.setText(controller.getCurrentFilePath());

        this.frame.setContentPane(mainPanel);
    }

    private void display() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationByPlatform(true);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    /**
     * Main funtion that starts a new UI.
     * 
     * @param args args passed in input.
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();
    }
}
