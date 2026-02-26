import java.io.*;
import java.util.Scanner;

public class Main {

  public static final File BINARY_FILE = new File("FoodJournal.dat");

  public static void main(String[] args) throws MysterMeatException, InterruptedException {

    // Variables
    Scanner keyboard = new Scanner(System.in);
    int choice, calories, carbs, cookingTemp, count=0;
    String name, type;
    boolean organic;
    PaleoFood[] foods = new PaleoFood[100];

    // DONE: Read existing PaleoFood objects from the binary file into the array

    if (BINARY_FILE.exists() && BINARY_FILE.length() >= 5)
    {
      try
      {
        ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE));
        foods = (PaleoFood[]) fileReader.readObject();

        for (int i = 0; i < foods.length; i++) {
          if (foods[i] == null)
            break;
          count++;
        }

        fileReader.close();

        for (int i = 0; i < count; i++) {
          System.out.println(foods[i]);
        }

        // DONE: Function that gathers total numbers of calories consumed
        System.out.println("Total Calories Consumed: " + totalCalories(foods, count));
        // DONE: Function that displays total number of organic produce consumed
        System.out.println("Food with Most Calories: " + meatWithMostCalories(foods, count));


      } catch (IOException | ClassNotFoundException e) {
        System.out.println(e.getMessage());
      }
    }
    else
      System.out.println("[No food eaten. You must be hungry.]");



    do {
      System.out.println("\n~~~Welcome to the Paleo Food Journal~~~\n");
      System.out.println("Enter (1) to record meat");
      System.out.println("Enter (2) to record produce");
      System.out.println("Enter (3) to quit");
      choice = keyboard.nextInt();
      // Clear the \n from keyboard
      keyboard.nextLine();

      switch (choice) {
        // Choice 1: Meat
        case 1:
          System.out.print("\nWhat is the name of the meat eaten? ");
          name = keyboard.nextLine();
          System.out.print("How many calories was it? ");
          calories = keyboard.nextInt();
          System.out.print("Enter (1) for animal or (2) for seafood: ");
          choice = keyboard.nextInt();
          // Make a decision: 1 means "Meat", 2 means "Seafood"
          if (choice == 1)
            type = "Meat";
          else if (choice == 2)
            type = "Seafood";
		  else {
            // Done: Raise (throw) the MysteryMeatException here.
            throw new MysterMeatException();
          }
		  

          System.out.print("Enter the cooking temperature: ");
          cookingTemp = keyboard.nextInt();

          // DONE: Instantiate a new Meat object and store it in the array (journal)
          foods[count++] = new Meat(name, calories, choice, cookingTemp);

          break;

        // Choice 2: Produce
        case 2:
          System.out.print("\nWhat is the name of the produce eaten? ");
          name = keyboard.nextLine();
          System.out.print("How many calories was it? ");
          calories = keyboard.nextInt();
          System.out.print("How many carbohydrates? ");
          carbs = keyboard.nextInt();
          System.out.print("Enter (1) for organic or (2) for non-organic: ");
          choice = keyboard.nextInt();  // choice is either 1 or 2
          organic = (choice == 1);

          // DONE: Instantiate a new Produce object and store it in the array (journal)
          foods[count++] = new Produce(name, calories, carbs, organic);

          break;

        // Choice 3:
        case 3:
          System.out.println("\n~~~Food Recorded in Journal~~~\n");
          // DONE: Loop through array, print out each paleo food
          for (int i = 0; i < count; i++) {
            System.out.println(foods[i]);
          }

         // TODO: Display statistics
          System.out.println("\nTotal calories consumed   = " + totalCalories(foods, count));
          System.out.println("Average calories consumed = " + totalCalories(foods, count) / (double) count);
          System.out.println("Food with most calories   = " + meatWithMostCalories(foods, count));
          System.out.println("Eat healthy and enjoy your break!");
          break;
        default:
          System.err.println("Invalid input. Enter a valid choice (1-3).");
          Thread.sleep(500);
      }
    } while (choice != 3);

    // DONE: After the loop, write PaleoFood objects from array into the binary file.
    try
    {
      ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE));
      fileWriter.writeObject(foods);
      fileWriter.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

      // Close the keyboard
    keyboard.close();
  }

  // DONE: Create a method named public static int totalCalories that takes, as input, an array of PaleoFood.
  //  This method should loop through all the food in the array,
  //  add up the calories of each item and return the total calories.
  public static int totalCalories(PaleoFood[] a, int count)
  {
    int sum = 0;

    for (int i = 0; i < count; i++) {
      sum += a[i].getCalories();
    }

    return sum;
  }

  // DONE: Create a method named public static PaleoFood foodWithMostCalories that takes, as input, an array of PaleoFood.
  //  This method should loop through all the food in the array and determine the Meat (object)
  //  with the most calories.

  public static Meat meatWithMostCalories(PaleoFood[] a, int count)
  {
    Meat maxMeat = null;
    double maxCal = 0.0;

    //Loop through array, ignore produce and only track meats
    for (int i = 0; i < count; i++)
    {
      //Check to see if object (a[i]) is a meat
      //using instanceof which checks if an object is an instance
      //of a class.
      if (a[i] instanceof Meat meat)
      {
        //Downcast a[i] into Meat
        //This makes a[i] into a meat.
        //Down is getting into the nitty gritty.
        //More specific. Into more of a descendant.

          if (meat.getCalories() > maxCal)
        {
          maxCal = meat.getCalories();
          maxMeat = meat;
        }
      }
    }

    return maxMeat;
  }

}
