package parser;

import commands.*;
import exception.LunaException;
import tasks.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parser {
    public static Command parse(String cmd) throws LunaException {
        String[] cmdSplit = cmd.split(" ", 2);
        Command c;
        switch (cmdSplit[0]) {
        case "todo":
            if (cmd.length() <= 5) {
                throw new LunaException("Please enter a task to do 🌷");
            }
            c = new AddCommand(cmdSplit[1], false);
            break;
        case "deadline":
            if (cmd.length() <= 9) {
                throw new exception.LunaException("Please enter a task and deadline 🌷");
            }
            String[] desSplit = cmdSplit[1].split(" /by ");
            c = new AddCommand("deadline", desSplit[0], desSplit[1], false);
            break;
        case "event":
            if (cmd.length() <= 6) {
                throw new exception.LunaException("Please enter an event and date 🌷");
            }
            String[] split = cmdSplit[1].split(" /at ");
            c = new AddCommand("event", split[0], split[1], false);
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
        default:
            throw new LunaException("I'm not sure what that means 🥀");
        }
        return c;
    }

    public static Task parseSaved(String tasks) {
        String txt = tasks.substring(7);
        if (txt.startsWith("[T]")) {
            String[] split = txt.split("] ");
            Task tsk = new Todo(split[1]);

            if (split[0].substring(3).equals("[✧")) {
                tsk.setStatusIcon(true);
            }
            return tsk;


        } else if (txt.startsWith("[D]")) {
            String[] split = txt.split("] ");
            String [] desSplit = split[1].split(" BY ");
            String des = desSplit[0];
            String by = desSplit[1].substring(0, 11);
            LocalDate date = LocalDate.parse(by, DateTimeFormatter.ofPattern("dd MMM yyyy"));

            Task tsk = new Deadline(des, date);

            if (split[0].substring(3).equals("[✧")) {
                tsk.setStatusIcon(true);
            }
            return tsk;


        } else if (txt.startsWith("[E]")) {
            String[] split = txt.split("] ");
            String [] desSplit = split[1].split(" AT ");
            String des = desSplit[0];
            String at = desSplit[1].substring(0, 11);
            LocalDate date = LocalDate.parse(at, DateTimeFormatter.ofPattern("dd MMM yyyy"));

            Task tsk = new Event(des, date);

            if (split[0].substring(3).equals("[✧")) {
                tsk.setStatusIcon(true);
            }
            return tsk;

        } else {
            return null;
        }
    }
}