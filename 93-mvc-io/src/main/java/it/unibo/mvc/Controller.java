package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * This function sets the new string to print.
     *
     * @param nextString The string to set as next to print.
     */
    void setNextString(String nextString);

    /**
     * This function return the actual set string.
     * 
     * @return actual set string.
     */
    String getNextString();

    /**
     * Returns a list with the string history.
     *
     * @return a list that contains the printed string history.
     */
    List<String> getStringHistory();

    /**
     * Prints the current string in the standard output.
     */
    void printCurrentString();
}
