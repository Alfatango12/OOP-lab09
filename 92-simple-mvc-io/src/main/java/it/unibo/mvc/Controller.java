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

    private String filePath;
    private final String systemSeparator;
    private PrintStream filePrintStream;

    /**
     * Constructor or fhe class.
     * Makes a file with default values.
     * 
     * @throws IOException required to open a new PrintStream.
     */
    public Controller() throws IOException {
        this.systemSeparator = System.getProperty("file.separator");
        this.filePath = System.getProperty("user.home") + this.systemSeparator + DEFAULT_FILE_NAME;
        this.filePrintStream = new PrintStream(this.filePath, StandardCharsets.UTF_8);
    }

    /**
     * Method that opens a new file.
     * 
     * @param newFilePath The path of the file
     * @throws IOException required to open a new PrintStream.
     */
    public void setCurrentFile(final String newFilePath) throws IOException {
        this.filePath = newFilePath;
        this.filePrintStream = new PrintStream(this.filePath);
    }

    /**
     * Returns the current file as a PrintStream object.
     * 
     * @return the PrintStream that represents the file.
     */
    public File getCurrentFile() {
        return new File(this.filePath);
    }

    /**
     * Methods that return the current file path.
     * 
     * @return the current file path
     */
    public String getCurrentFilePath() {
        return this.filePath;
    }

    /**
     * Writes a string to the current file.
     * 
     * @param output the string to write to file.
     */
    public void writeStringToFile(final String output) {
        this.filePrintStream.println(output);
    }
}
