package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that manages the printing of a string in the standard output.
 * Implements the {@link Controller} interface. 
 */
public final class SimpleController implements Controller {
    private String nextString;
    private final List<String> history = new LinkedList<>();

    /**
     * Constructor with no arguments. It makes the string as unset by default.
     */
    public SimpleController() {
        /* Made an empty constructor because the string can also be set after creation. */
    }

    /**
     * Constructor that takes a string to set as next to print.
     * The setting is made by calling the {@link setNextString} method.
     * 
     * @param nextString the string to set as next to print.
     */
    public SimpleController(final String nextString) {
        setNextString(nextString);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNextString(final String nextString) {
        if (nextString != null) {
            this.nextString = nextString;
        } else {
            throw new IllegalArgumentException("The string cannot have NULL values");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNextString() {
        return this.nextString;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getStringHistory() {
        return List.copyOf(history);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printCurrentString() {
        if (this.nextString == null) {
            throw new IllegalStateException("The next string cannot be unset");
        } else {
            System.out.println(this.nextString); //NOPMD
            history.add(this.nextString);
        }
    }
}
