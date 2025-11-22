package it.unibo.mvc;

import java.io.IOException;
import java.io.PrintStream;
import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private static final String DEFAULT_FILE_NAME = "output.txt";

    private File file;

    /**
     * Constructor or fhe class.
     * Makes a file with default values.
     */
    public Controller() {
        this.file = new File(System.getProperty("user.home") + System.getProperty("file.separator") + DEFAULT_FILE_NAME);
    }

    /**
     * Method that opens a new file.
     * 
     * @param newFilePath The path of the file
     */
    public void setCurrentFile(final String newFilePath) {
        this.file = new File(newFilePath);
    }

    /**
     * Returns the current file as a PrintStream object.
     * 
     * @return the file object.
     */
    public File getCurrentFile() {
        return this.file;
    }

    /**
     * Methods that return the current file path.
     * 
     * @return the current file path.
     */
    public String getCurrentFilePath() {
        return this.file.getPath();
    }

    /**
     * Writes a string to the current file.
     * 
     * @param output the string to write to file.
     */
    public void writeStringToFile(final String output) throws IOException {
        try (final PrintStream ps = new PrintStream(file, StandardCharsets.UTF_8)) {
            ps.println(output);
        }
    }
}
