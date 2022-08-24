package parser;

// Import Commands
import command.AddCommand;
import command.Command;
import command.DeleteCommand;
import command.ExitCommand;
import command.FindCommand;
import command.ListCommand;
import command.UpdateCommand;

import exception.LunaException;

// Import Tasks;
import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;
import task.Todo;

// Imports for dates
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Deals with making sense of the user command.
 *
 * @author fannyjian
 */
public class Parser {

    /**
     * Takes in a string of user command and creates a new instance of Command
     * according to the keyword.
     *
     * @param cmd String of command to process.
     * @return Command corresponding to the user's instruction.
     * @throws LunaException.
     */
    public static Command parse(String cmd) throws LunaException {
        String[] cmdSplit = cmd.split(" ", 2);
        Command c;
        switch (cmdSplit[0]) {
        case "todo":
            if (cmd.length() <= 5) {
                throw new LunaException("Please enter a task to do 🌷");
            }
            c = new AddCommand(cmdSplit[1]);
            break;
        case "deadline":
            if (cmd.length() <= 9) {
                throw new exception.LunaException("Please enter a task and deadline 🌷");
            }
            String[] desSplit = cmdSplit[1].split(" /by ");
            c = new AddCommand("deadline", desSplit[0], desSplit[1]);
            break;
        case "event":
            if (cmd.length() <= 6) {
                throw new exception.LunaException("Please enter an event and date 🌷");
            }
            String[] split = cmdSplit[1].split(" /at ");
            c = new AddCommand("event", split[0], split[1]);
            break;
        case "list":
            c = new ListCommand();
            break;
        case "bye":
            c = new ExitCommand();
            break;
        case "delete":
            c = new DeleteCommand(Integer.parseInt(cmdSplit[1]));
            break;
        case "mark":
            c = new UpdateCommand("mark", Integer.parseInt(cmdSplit[1]));
            break;
        case "unmark":
            c = new UpdateCommand("unmark", Integer.parseInt(cmdSplit[1]));
            break;
        case "find":
            c = new FindCommand(cmdSplit[1].toLowerCase());
            break;
        default:
            throw new LunaException("I'm not sure what that means 🥀");
        }
        return c;
    }

    /**
     * Process the lines of text from the hard disk by converting strings of tasks into
     * appropriate Task instances.
     *
     * @param tasks String of task to be converted to a Task instance
     * @return A Task instance.
     */
    public static Task parseSaved(String tasks) {
        String txt = tasks.substring(7);
        if (txt.startsWith("[T]")) {
            // Abstract task description
            String[] split = txt.split("] ");

            // Create new Todo
            Task tsk = new Todo(split[1]);

            // Update status
            if (split[0].substring(3).equals("[✧")) {
                tsk.setStatusIcon(true);
            }
            return tsk;
        } else if (txt.startsWith("[D]")) {
            // Abstract task description and date
            String[] split = txt.split("] ");
            String [] desSplit = split[1].split(" BY ");
            String des = desSplit[0];
            String by = desSplit[1].substring(0, 11);

            // Create date
            LocalDate date = LocalDate.parse(by, DateTimeFormatter.ofPattern("dd MMM yyyy"));

            // Create new Deadline
            Task tsk = new Deadline(des, date);

            // Update status
            if (split[0].substring(3).equals("[✧")) {
                tsk.setStatusIcon(true);
            }
            return tsk;
        } else if (txt.startsWith("[E]")) {
            // Abstract task description and date
            String[] split = txt.split("] ");
            String [] desSplit = split[1].split(" AT ");
            String des = desSplit[0];
            String at = desSplit[1].substring(0, 11);

            // Create date
            LocalDate date = LocalDate.parse(at, DateTimeFormatter.ofPattern("dd MMM yyyy"));

            // Create new Event
            Task tsk = new Event(des, date);

            // Update status
            if (split[0].substring(3).equals("[✧")) {
                tsk.setStatusIcon(true);
            }
            return tsk;
        } else {
            return null;
        }
    }
}
