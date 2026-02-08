import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        boolean keepGoing = true;
        int rating = 0, min = 1, max = 5;
        Scanner keyboard = new Scanner(System.in);

        do
        {
            try
            {
                System.out.print("Please enter a rating between " + min + " and " + max + ": ");
                rating = keyboard.nextInt();
                if (rating < min || rating > max)
                    throw new InputMismatchException();
                keepGoing = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Enter only integral numbers between 1 and 5");
            }
            keyboard.nextLine();
        } while(keepGoing);

        System.out.println("\nThe rating you entered is: " + rating);
        keyboard.close();
    }
}
