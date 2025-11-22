package it.unibo.mvc;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private static final String DEFAULT_FILE_NAME = "output.txt";

    private String filePath;
    private final String systemSeparator;
    private PrintStream file;

    /**
     * 
     * @throws IOException
     */
    public Controller() throws IOException {
        this.systemSeparator = System.getProperty("file.separator");
        this.filePath = System.getProperty("user.home");
        this.file = new PrintStream(this.filePath + systemSeparator + DEFAULT_FILE_NAME, StandardCharsets.UTF_8);
    }

    /**
     * 
     * @param filePath
     * @throws IOException
     */
    public void setCurrentFile(final String filePath) throws IOException {
        this.filePath = filePath;
        this.file = new PrintStream(this.filePath);
    }

    /**
     * 
     * @return
     */
    public PrintStream getCurrentFile() {
        return this.file;
    }

    /**
     * 
     * @return
     */
    public String getCurrentFilePath() {
        return this.filePath;
    }

    /**
     * 
     * @param output
     */
    public void writeStringToFile(final String output) {
        this.file.println(output);
    }
}
