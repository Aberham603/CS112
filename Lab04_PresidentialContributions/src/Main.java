import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static final String FILE_NAME = "report_summaries_form_3p.csv";
    public static final String HARRIS = "HARRIS";
    public static final String DELACRUZ = "DE LA CRUZ";

    public static void main(String[] args) {

        Scanner file = null;
        NumberFormat number = NumberFormat.getInstance();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        int totalHarrisContributions = 0, totalDeLaCruzContributions = 0;
        double amount = 0, totalAmountHarris = 0, totalAmountDeLaCruz = 0,
                maxHarris = Double.MIN_VALUE, minHarris = Double.MAX_VALUE,
                maxDeLaCruz = Double.MIN_VALUE, minDeLaCruz = Double.MAX_VALUE;
        String candidateName = null;
        String[] list;

        try {
            file = new Scanner(new File(FILE_NAME));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        file.nextLine();

        while(file.hasNextLine())
        {
            String line = file.nextLine();
            list = line.split(",");
            candidateName = list[8];
            
            if (candidateName.endsWith(HARRIS))
            {
                amount = Double.parseDouble(list[43]);

                if (amount > maxHarris)
                    maxHarris = amount;
                if (amount < minHarris)
                    minHarris = amount;
                totalAmountHarris += amount;
                totalHarrisContributions++;
            }
            if (candidateName.endsWith(DELACRUZ))
            {
                amount = Double.parseDouble(list[43]);

                if (amount > maxDeLaCruz)
                    maxDeLaCruz = amount;
                if (amount < minDeLaCruz)
                    minDeLaCruz = amount;
                totalAmountDeLaCruz += amount;
                totalDeLaCruzContributions++;
            }
            


        }

        System.out.println("************************************************");
        System.out.println("*   2024 Presidential Campaign Contributions   *");
        System.out.println("*               For Candidate                  *");
        System.out.println("*               Kamala Harris                  *");
        System.out.println("************************************************");
        System.out.println("The # of contributions is: " + number.format(totalHarrisContributions));
        System.out.println("The minimum contribution is: " + currency.format(minHarris));
        System.out.println("The maximum contribution is: " + currency.format(maxHarris));
        System.out.println("The maximum contribution is: " + currency.format(totalAmountHarris/totalHarrisContributions));
        System.out.println("The total contributed is: " + currency.format(totalAmountHarris));
        System.out.println("************************************************");
        System.out.println("*   2024 Presidential Campaign Contributions   *");
        System.out.println("*               For Candidate                  *");
        System.out.println("*             Claudia De La Cruz               *");
        System.out.println("************************************************");
        System.out.println("The # of contributions is: " + number.format(totalDeLaCruzContributions));
        System.out.println("The minimum contribution is: " + currency.format(minDeLaCruz));
        System.out.println("The maximum contribution is: " + currency.format(maxDeLaCruz));
        System.out.println("The maximum contribution is: " + currency.format(totalAmountDeLaCruz/totalDeLaCruzContributions));
        System.out.println("The total contributed is: " + currency.format(totalAmountDeLaCruz));

        file.close();

    }
}