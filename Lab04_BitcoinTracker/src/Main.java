import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    static final String FILE_NAME = "bitcoin_prices_full.txt";

    public static void main(String[] args)
    {
        /*
        Your task is to write a Java console application that loops
        through one of the files (start with lite, then move to full)
        and calculates the following statistics about Bitcoin from 2012 - 2023:

        - The exact number of Bitcoin prices in the file (count)
        - The average Bitcoin price over this time period
        - The lowest Bitcoin price over this time period
        - The highest Bitcoin price over this time period
         */
        Scanner file = null;
        //PrintWriter outputStream = null;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat commas = NumberFormat.getIntegerInstance();

        int count = 0;
        double totalBitcoinPrice = 0, lowestBitcoinPrice = Double.MAX_VALUE, highestBitcoinPrice = Double.MIN_VALUE;

        try
        {
            file = new Scanner(new FileInputStream(FILE_NAME));
            //file = new Scanner(new FileInputStream("bitcoin_prices_full.txt"));
            //outputStream = new PrintWriter(new FileOutputStream("bitcoin_file_revised.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.err.println("Problem opening file.");
            System.exit(0);
        }

        file.nextLine();

        while (file.hasNextDouble())
        {
            double bitcoinPrice = file.nextDouble();
            count++;
            totalBitcoinPrice += bitcoinPrice;

            if(highestBitcoinPrice < bitcoinPrice)
                highestBitcoinPrice = bitcoinPrice;

            if(lowestBitcoinPrice > bitcoinPrice)
                lowestBitcoinPrice = bitcoinPrice;
        }
/*
        while (file.hasNextLine())
        {
            if (file.hasNextDouble())
            {
                double bitcoinPrice = file.nextDouble();
                count++;
                totalBitcoinPrice += bitcoinPrice;

                if(highestBitcoinPrice < bitcoinPrice)
                {
                    highestBitcoinPrice = bitcoinPrice;
                }

                if(lowestBitcoinPrice > bitcoinPrice)
                {
                    lowestBitcoinPrice = bitcoinPrice;
                }
            }
            else
            {
                file.nextLine();
            }

        }
*/
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Bitcoin Statistics: Jan 2012 - Sep 2023");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Number of Price Quotes: " + commas.format(count));
        System.out.println("Average Price: " + currency.format(totalBitcoinPrice/count));
        System.out.println("Lowest Price: " + currency.format(lowestBitcoinPrice));
        System.out.println("Highest Price: " + currency.format(highestBitcoinPrice));

        file.close();
        //outputStream.close();
    }
}