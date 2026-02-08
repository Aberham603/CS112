import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        //String Appointment array that holds 6 appointments
        String[] appointments = new String[6];
        int count = 0;
        Scanner keyboard = new Scanner(System.in);

        do {
            try
            {
                System.out.println("\nHere are the current appointments: ");

                //Prints out all appointments.
                for (int i = 0; i < appointments.length; i++) {
                    System.out.print((i+1) + ":00 pm: ");
                    //If the appointment is empty, it prints [empty]
                    if (appointments[i] == null)
                        System.out.println("[empty]");
                    //Otherwise, the string is printed.
                    else
                        System.out.println(appointments[i]);
                    /*
                    Code I did myself, but video code was better.
                    if (appointments[i] == null)
                        System.out.println((i+1) + ":00 pm: [empty]" );
                    else
                        System.out.println((i+1) + ":00 pm: " + appointments[i]);
                     */
                }

                System.out.print("\nWhat time (1-6pm) would you like to schedule an appointment? ");
                int choice = keyboard.nextInt();
                keyboard.nextLine();
                //If the choice is not within 1-6 then do throw an InvalidTimeException.
                if (choice > 6 || choice < 0) {
                    throw new InvalidTimeException();
                }
                //If the choice is already filled, then throw a TimeInUseException.
                else if (appointments[choice-1] != null)
                    throw new TimeInUseException();
                else
                {
                    System.out.print("Enter the name of person reserving this appointment: ");
                    appointments[choice-1] = keyboard.nextLine();
                    count++;
                }
            }
            //Print out the message of the respective exception.
            catch (InvalidTimeException | TimeInUseException e)
            {
                System.out.println("\n" + e.getMessage());
            }
            /*
            Code I did myself, but video code was better.

            catch (InvalidTimeException e)
            {
                System.out.println(e.getMessage());
                System.out.println();
            }
            catch (TimeInUseException e)
            {
                System.out.println(e.getMessage());
                System.out.println();
            }
             */
            //In case the user types anything besides an integer.
            catch (InputMismatchException e)
            {
                System.out.println("\nInput an integral number.");
                keyboard.nextLine();
            }
        }while(count < 6);

        //Once the appointment array is filled up, print out the finalized version.
        System.out.println("Here are all finalized appointments:");
        for (int i = 0; i < appointments.length; i++) {
            System.out.println((i+1) + ":00 pm: " + appointments[i]);
        }
        System.out.println("\nAll appointments have been booked!");
        keyboard.close();
    }
}
