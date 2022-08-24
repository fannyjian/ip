package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Encapsulates a task that need to be done before a specific date.
 *
 * @author fannyjian
 */
public class Deadline extends Task {

    private static final DateTimeFormatter TO = DateTimeFormatter.ofPattern("dd MMM yyyy");
    protected LocalDate by;

    /**
     * Creates a new Deadline instance with the given specification and
     * target date of completion.
     *
     * @param description Specification of task to be completed.
     * @param by Target date of completion.
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the string representation of the Deadline with type and date specified.
     *
     * @return String representation of the Deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " BY " + this.by.format(TO);
    }
}