import java.io.*;
import java.util.Scanner;

public class Main {

    public static final File BINARY_FILE = new File("TaskList.dat");

    public static void main(String[] args) 
    {
        Task[] taskList = new Task[100];
        String name, dueDate, deadline;
        int priority;
        int count = 0;
        String choice;
        Scanner keyboard = new Scanner(System.in);

        // 1. Read from the file and add the objects into the array.
        System.out.println("Loading any previous tasks...");

        if (BINARY_FILE.exists() && BINARY_FILE.length() >= 5)
        {
            try
            {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE));
                taskList = (Task[]) fileReader.readObject();

                for (int i = 0; i < taskList.length; i++) {
                    if (taskList[i] == null)
                    {
                        break;
                    }
                    count++;
                }

                fileReader.close();
            }
            catch (IOException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }

        if (count == 0)
            System.out.println("0 tasks found. Enter new ones.");
        else
        {
            System.out.println(count + " previously task(s) loaded in from the binary file.\n");
            for (int i = 0; i < count; i++) {
                System.out.println(taskList[i]);
            }
        }

        // 2. Allow the user to input into array.
        do {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Please enter task name (or \"quit\" to exit): ");
            name = keyboard.nextLine();

            if (!name.equalsIgnoreCase("quit"))
            {
                System.out.print("Enter Due Date (MM/DD/YYYY): ");
                dueDate = keyboard.nextLine();
                System.out.print("Enter Deadline (XX:XX XM): ");
                deadline = keyboard.nextLine();
                System.out.print("Enter Priority from 1 (Highest) to 3 (Lowest): ");
                priority = keyboard.nextInt();
                keyboard.nextLine();

                taskList[count++] = new Task(name, dueDate, deadline, priority);
            }

        } while(!name.equalsIgnoreCase("quit"));


        // 3. Save array into file.

        try
        {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE));
            fileWriter.writeObject(taskList);
            fileWriter.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Saved " + count + " tasks to file.");
    }
}
