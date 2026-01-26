import java.text.NumberFormat;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String name, flavor;
        int choice, ounces, roastType, count = 0;
        double price;

        // Array - Collection of data under the same data type
        // Use parent class as the data type
        CaffeinatedBeverage[] drinks = new CaffeinatedBeverage[10];

        // To get use input from keyboard, need a Scanner
        Scanner keyboard = new Scanner(System.in);

        //In a loop, prompt the user with 3 options to enter a new Coffee (Option 1)
        //or EnergyDrink(Option 2) in the inventory.
        do {
            System.out.println("What would you like to add to yourself?");
            System.out.println("[1] Coffee");
            System.out.println("[2] Energy Drink");
            System.out.println("[3] Exit");
            System.out.print(">> ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            switch(choice)
            {
                case 1:
                    //Prompt the user to make a coffee.
                    //Ask for name, ounces, price, and roast type!
                    System.out.println("What is the name of the coffee?");
                    System.out.print(">> ");
                    name = keyboard.nextLine();

                    System.out.println("How many ounces?");
                    System.out.print(">> ");
                    ounces = keyboard.nextInt();

                    System.out.println("How much is it?");
                    System.out.print(">> $");
                    price = keyboard.nextDouble();

                    System.out.println("What is the roast type?");
                    System.out.println("[1] Light Roast");
                    System.out.println("[2] Medium Roast");
                    System.out.println("[3] Dark Roast");
                    System.out.print(">> ");
                    roastType = keyboard.nextInt();

                    //Add coffee to the inventory.
                    drinks[count++] = new Coffee(name, ounces, price, roastType);
                    break;
                case 2:
                    //Prompt the user to make a coffee.
                    //Ask for name, ounces, price, and roast type!
                    System.out.println("What is the name of the energy drink?");
                    System.out.print(">> ");
                    name = keyboard.nextLine();

                    System.out.println("How many ounces?");
                    System.out.print(">> ");
                    ounces = keyboard.nextInt();

                    System.out.println("How much is it?");
                    System.out.print(">> $");
                    price = keyboard.nextDouble();
                    keyboard.nextLine();

                    System.out.println("What is the flavor?");
                    System.out.print(">> ");
                    flavor = keyboard.nextLine();

                    //Add coffee to the inventory.
                    drinks[count++] = new EnergyDrink(name, ounces, price, flavor);
                    break;
                case 3:

                    if (count != 0)
                    {
                        //loop through the array and print each object to the console.
                        for (int i = 0; i < count; i++) {
                            System.out.println(drinks[i]);
                        }
                        // Then display the average price of all the beverages and the EnergyDrink
                        NumberFormat currency = NumberFormat.getCurrencyInstance();
                        System.out.println("The average price of all your drinks is " + currency.format(findAveragePrice(drinks, count)) + ".");
                        // with the highest price (maximum price)
                        // using the methods you write in the next step.
                        EnergyDrink expensiveDrink = findHighestPricedEnergyDrink(drinks, count);
                        if (expensiveDrink != null)
                            System.out.println("The most expensive energy drink you have is " + expensiveDrink.getName() + ".");
                        else
                            System.out.println("You do not have any energy drinks.");
                    }
                    else
                    {
                        System.out.println("Thank you! Come again!");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Enter a choice from 1 - 3.");
            }
        }while(choice != 3);
    }

    //Find the average of all beverages (Coffee and Energy Drinks together)
    public static double findAveragePrice(CaffeinatedBeverage[] inventory, int count)
    {
        double sum = 0;

        for (int i = 0; i < count; i++)
        {
            sum += inventory[i].getPrice();
        }

        return sum/count;
    }

    public static EnergyDrink findHighestPricedEnergyDrink(CaffeinatedBeverage[] inventory, int count)
    {
        EnergyDrink maxDrink = null;
        double maxPrice = 0.0;

        //Loop through array, ignore coffee and only track energy drinks
        for (int i = 0; i < count; i++)
        {
            //Check to see if object(inventory[i] is an energy drink
            //using instanceof which checks if an object is an instance
            //of a class.
            if (inventory[i] instanceof EnergyDrink)
            {
                //Downcast inventory[i] into EnergyDrink
                //This makes inventory[i] into an energy drink
                //Down is getting into the nitty gritty.
                //More specific. Into more of a descendant.
                EnergyDrink drink = (EnergyDrink)inventory[i];

                if (drink.getPrice() > maxPrice)
                {
                    maxPrice = drink.getPrice();
                    maxDrink = drink;
                }
            }
        }

        return maxDrink;
    }
}