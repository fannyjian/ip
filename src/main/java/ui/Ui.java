package ui;

import tasks.Task;
import tasks.TaskList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ui {
    private static final String SEP = "\n✧  ✡︎✮ ✰ ✦ ✨️ ❍  ✫   ✣❈ ✶  ✧︎ ✱✬ ✨   ❇︎ ✫❍   ❈ ✶  ❍✶  ✯❃  ✨\n";
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
        // Print Welcome message
        String logo =
                  "    _\n"
                + "   | |    _   _ _____   ___ _\n"
                + "   | |   | | | |  __ \\ /     |\n"
                + "   | |__ | |_| | |  | |    | |\n"
                + "   |____| \\__,_|_|  |_|\\__/|_|\n";
        System.out.println(SEP + "\nHello. ⛅️\n   This is\n" + logo);

        // Print available commands
        System.out.println("  Luna commands" +
                    "\n    🌸 list                             | View all tasks on your agenda" +
                    "\n    🌷 todo \"task\"                      | Add a task to your agenda" +
                    "\n    🌺 deadline \"task\" /by \"yyyy-mm-dd\" | Add a task to complete by the specified deadline" +
                    "\n    🌹 event \"event\" /at \"yyyy-mm-dd\"   | Add an event on the specified date" +
                    "\n    🪷 mark \"num\"                       | Mark the (num)th item in your list as completed"+
                    "\n    🌻 unmark \"num\"                     | Mark the (num)th item in your list as uncompleted" +
                    "\n    🥀 bye                              | Quit Luna\n");

        // Print items in storage
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

        // Print final separation line
        System.out.println(SEP);
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
        System.out.println(SEP);
    }

    public void showError(String message) {
        showLine();
        System.out.println(message);
        showLine();
    }

    public void showAdded(TaskList tasks, Task task) {
        showLine();
        System.out.println("Luna has added:\n" + task.toString() + "\n" + tasks.size() + " task(s) left in your list 🌻");
        showLine();
    }

    public void showDeleted(TaskList tasks, Task task) {
        showLine();
        System.out.println("Luna has removed:\n" + task.toString() + "\n" + tasks.size() + " task(s) left in your list 🌻)");
        showLine();

    }

    public void showList(TaskList tasks) {
        showLine();
        System.out.println("\n☀️ Stuff you have to do! ☀️\n");
        System.out.println(tasks);
        showLine();
    }

    public void showMark(Task task) {
        showLine();
        System.out.println("Marked as completed 🌈️\n" + task.toString());
        showLine();
    }

    public void showUnmark(Task task) {
        showLine();
        System.out.println("Marked as uncompleted 🌩\n" + task.toString());
        showLine();
    }

    public String readCommand() {
        return sc.nextLine();
    }
}
