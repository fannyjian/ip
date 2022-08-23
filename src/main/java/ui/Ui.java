package ui;

import tasks.Task;
import tasks.TaskList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ui {
    private static final String sep = "\n✧  ✡︎✮ ✰ ✦ ✨️ ❍  ✫   ✣❈ ✶  ✧︎ ✱✬ ✨   ❇︎ ✫❍   ❈ ✶  ❍✶  ✯❃  ✨\n";
    private static Scanner sc;
    private boolean loaded;

    public Ui() {
        this.sc = new Scanner(System.in);
        this.loaded = false;
    }

    public void setLoaded() {
        this.loaded = true;
    }

    public void showWelcome() {
        //print Welcome message
        String logo =
                  "    _\n"
                + "   | |    _   _ _____   ___ _\n"
                + "   | |   | | | |  __ \\ /     |\n"
                + "   | |__ | |_| | |  | |    | |\n"
                + "   |____| \\__,_|_|  |_|\\__/|_|\n";
        System.out.println(sep + "\nHello. ⛅️\n   This is\n" + logo);

        //print available commands
        System.out.println("  Luna commands" +
                    "\n    🌸 list                             | View all tasks on your agenda" +
                    "\n    🌷 todo \"task\"                      | Add a task to your agenda" +
                    "\n    🌺 deadline \"task\" /by \"yyyy-mm-dd\" | Add a task to complete by the specified deadline" +
                    "\n    🌹 event \"event\" /at \"yyyy-mm-dd\"    | Add an event on the specified date" +
                    "\n    🪷 mark \"num\"                       | Mark the (num)th item in your list as completed"+
                    "\n    🌻 unmark \"num\"                     | Mark the (num)th item in your list as uncompleted" +
                    "\n    🥀 bye                              | Quit Luna\n");

        //print items in storage
        if (!this.loaded) {
            System.out.println("  You do not have anything to do yet!\n  Tell Luna your tasks for the day ☀️");
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("data/luna.txt"));
                Stream<String> content = reader.lines();

                content.forEach(s -> System.out.println(s));
            } catch (FileNotFoundException e) {
                showLoadingError();
            }
        }

        //print final separation line
        System.out.println(sep);
    }

    public void showLoadingError() {
        System.out.println("⚡️Luna has encountered an error while loading tasks⚡️" +
                    "\n️Please exit and try again ️⛈");
    }

    public void farewell() {
        System.out.println("\n . ❍  ❃ ☆  ✶ ❅  🌙 Goodbye from Luna 🌙  ❅ ✶  ☆ ❃  ❍  .\n");
        sc.close();
    }

    public void showLine() {
        System.out.println(sep);
    }

    public void showError(String message) {
        showLine();
        System.out.println(message);
        showLine();
    }

    public void showAdded(TaskList tasks, Task task) {
        System.out.println(sep + "\nLuna has added:\n" + task.toString() + "\n" + tasks.size() + " task(s) left in your list 🌻\n" + sep);
    }

    public void showDeleted(TaskList tasks, Task task) {
        System.out.println(sep + "\nLuna has removed:\n" + task.toString() + "\n" + tasks.size() + " task(s) left in your list 🌻\n" + sep);

    }

    public void showList(TaskList tasks) {
        showLine();
        System.out.println("\n☀️ Stuff you have to do! ☀️\n");
        System.out.println(tasks);
        showLine();
    }

    public void showMark(Task task) {
        System.out.println(sep + "\nMarked as completed 🌈️\n" + task.toString() + "\n" + sep);
    }

    public void showUnmark(Task task) {
        System.out.println(sep + "\nMarked as uncompleted 🌩\n" + task.toString() + "\n" + sep);
    }

    public String readCommand() {
        return sc.nextLine();
    }
}
