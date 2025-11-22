package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();

    /**
     * Constructor that makes the UI components.
     */
    public SimpleGUI() {
        // Creating Componenets.
        final Controller controller = new SimpleController();
        final JPanel mainPanel = new JPanel();
        final JTextField printedString = new JTextField();
        final JTextArea printedHistory = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton show = new JButton("Show History");
        // Setting properties.
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(printedString, BorderLayout.NORTH);
        mainPanel.add(printedHistory, BorderLayout.CENTER);
        mainPanel.add(print, BorderLayout.SOUTH);
        mainPanel.add(show, BorderLayout.SOUTH);
        // Event Listeners
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                printedString.setText(controller.getNextString());
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final var history = controller.getStringHistory();
                printedHistory.setText("");
                for (var elem : history) {
                    printedHistory.append(elem);
                }
            }
        });

        this.frame.setContentPane(mainPanel);
    }

    private void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
