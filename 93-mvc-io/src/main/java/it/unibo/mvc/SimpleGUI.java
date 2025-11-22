package it.unibo.mvc;

import javax.swing.BoxLayout;
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
        final JPanel bottomPanel = new JPanel();
        final JTextField stringToPrint = new JTextField();
        final JTextArea printedHistory = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton show = new JButton("Show History");
        // Setting properties.
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(stringToPrint, BorderLayout.NORTH);
        mainPanel.add(printedHistory, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.add(print);
        bottomPanel.add(show);
        printedHistory.setEditable(false);
        // Event Listeners
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextString(stringToPrint.getText());
                controller.printCurrentString();
                stringToPrint.setText("");
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final var history = controller.getStringHistory();
                printedHistory.setText("");
                for (final var elem : history) {
                    printedHistory.append(elem + "\n");
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

    /**
     * Main method that make the gui alive.
     * 
     * @param args unused.
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
