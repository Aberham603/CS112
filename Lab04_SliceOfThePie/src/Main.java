import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static final String FILE_NAME = "USPizzaDataset.csv";
    public static final String MY_CITY = "Oceanside";

    public static void main(String[] args)
    {
        // Extract 1 line from CSV file (Shotgun Dans)
        // Extract name of restaurant (10th column/position 9) and price (7th column/6th position for pizza pie

        String name = null, line = null, location, cheapestNationally = null, expensiveNationally = null,
                cheapestOceanside = null, expensiveOceanside = null;
        String[] parts;
        double price = 0, lowestPrice = Double.MAX_VALUE, highestPrice = Double.MIN_VALUE,
                lowestPriceOside = Double.MAX_VALUE, highestPriceOside = Double.MIN_VALUE, totalPriceOside = 0, totalPrice = 0;
        int totalPizzerias = 0, oSideLocations = 0;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat number = NumberFormat.getInstance();

        try {
            Scanner file = new Scanner(new File(FILE_NAME));
            // Skip the first line (headings)
            file.nextLine();

            while(file.hasNextLine())
            {
                line = file.nextLine();

                // Divide the line into individual parts wherever there's a comma
                parts = line.split(",");

                // Price comes from index 6 in the parts array, but it's a String
                // So we use Double.parseDouble to convert it into a double
                price = Double.parseDouble(parts[6]);

                //Name is a string, array is a String (no conversion needed).
                name = parts[9];

                location = parts[2];

                if (price > highestPrice) {
                    highestPrice = price;
                    expensiveNationally = name;
                }
                if (price < lowestPrice) {
                    lowestPrice = price;
                    cheapestNationally = name;
                }

                if (MY_CITY.equalsIgnoreCase(location))
                {
                    oSideLocations++;

                    if (price > highestPriceOside) {
                        highestPriceOside = price;
                        expensiveOceanside = name;
                    }
                    if (price < lowestPriceOside) {
                        lowestPriceOside = price;
                        cheapestOceanside = name;
                    }

                    totalPriceOside += price;
                }

                totalPrice += price;
                totalPizzerias++;

            }

            System.out.println("******************************************");
            System.out.println("*       US Pizza Dataset: National       *");
            System.out.println("******************************************");
            System.out.println("Number of entries reported (Nationally): " + number.format(totalPizzerias));
            System.out.println("Highest priced pizzeria (Nationally): " + expensiveNationally);
            System.out.println("Pizza Price: " + currency.format(highestPrice));
            System.out.println("Cheapest priced pizzeria (Nationally): " + cheapestNationally);
            System.out.println("Pizza Price: " + currency.format(lowestPrice));
            System.out.println("Average Price of Pizza (Nationally): " + currency.format(totalPrice/totalPizzerias));
            System.out.println("******************************************");
            System.out.println("Number of entries reported (Oceanside): " + number.format(oSideLocations));
            System.out.println("Highest priced pizzeria (Oceanside): " + expensiveOceanside);
            System.out.println("Pizza Price: " + currency.format(highestPriceOside));
            System.out.println("Cheapest priced pizzeria (Oceanside): " + cheapestOceanside);
            System.out.println("Pizza Price: " + currency.format(lowestPriceOside));
            System.out.println("Average Price of Pizza (Oceanside): " + currency.format(totalPriceOside/oSideLocations));

            file.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }
}