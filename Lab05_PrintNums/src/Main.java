public class Main {
    public static void main(String[] args) 
    {
/*
        System.out.print("PrintNums: ");
        printNums(5);
        System.out.println();
        System.out.print("PrintNumsAscending: ");
        printNumsAscending(12);
        System.out.println();
        System.out.println();

        System.out.println("=====Harmonic Series=====");
        System.out.println("Harmonic Series of 2: " + harmonicSeries(2));
        System.out.println("Harmonic Series of 3: " + harmonicSeries(3));
        System.out.println("Harmonic Series of 16: " + harmonicSeries(16));
        System.out.println();

        System.out.println("======Product of Evens=====");
        System.out.println("Product of Evens (1): " + productOfEvens(1));
        System.out.println("Product of Evens (4): " + productOfEvens(4));
        System.out.println();

        System.out.println("=====Funky Header=====");
        funkyHeader(1);
        System.out.println();
        funkyHeader(2);
        System.out.println();
        funkyHeader(3);
        System.out.println();
        funkyHeader(4);
        System.out.println();
        funkyHeader(5);
        System.out.println();
        funkyHeader(6);
        System.out.println();
        funkyHeader(7);
        System.out.println();
        funkyHeader(8);
        System.out.println();
        System.out.println();

        System.out.println("=====Count Numbers Of=====");

        int[] data = {1, 2, 6, 4, 3, 2};

        System.out.println("Looking for 2: " + countNumbersOf(2, data));
        System.out.println("Looking for 5: " + countNumbersOf(5, data));
        System.out.println("Looking for 6: " + countNumbersOf(6, data));

        System.out.println();
        System.out.println("=====How Many Digits Match=====");
        System.out.println("howManyDigitsMatch(1234567, 67): " + howManyDigitsMatch(1234567, 67));
        System.out.println("howManyDigitsMatch(380, 0): " + howManyDigitsMatch(380, 0));
        System.out.println("howManyDigitsMatch(5, 5552): " + howManyDigitsMatch(5, 5552));

 */
        //System.out.println(summation(10));
        writeSequence(1);
        System.out.println();
        writeSequence(2);
        System.out.println();
        writeSequence(3);
        System.out.println();
        writeSequence(4);
        System.out.println();
        writeSequence(5);
        System.out.println();
        writeSequence(6);

    }

    public static int summation(int n)
    {
        if (n <= 0)
            throw new IllegalArgumentException();
        else if (n == 1)
        {
            return 1;
        }
        else
        {
            return n + summation(n-1);
        }
    }

    //Prints a symmetric sequence of n numbers with descending integers ending
    // in 1 followed by ascending integers beginning with 1
    public static void writeSequence(int n)
    {
        String total = "";
        int b = n-2;
        int a = (n/2)+1;

        // Error Case
        if (n < 1)
            throw new IllegalArgumentException();
        // Base Cases
        else if (n == 1)
        {
            System.out.print(n);
        }
        else if (n == 2)
        {
            System.out.print((n-1) + " " + (n-1));
        }
        // Recursive Case
        else if (n % 2 == 0)
        {
            System.out.print((a-1) + " " );
            writeSequence(b);
            System.out.print(" " + (a-1));
        }
        else
        {
            System.out.print((a) + " ");
            writeSequence(b);
            System.out.print(" " + (a));
        }

    }

    /*
    public static String writeSequence(int n)
    {
        String total = "";
        int b = n-2;
        int a = (n/2)+1;

        // Error Case
        if (n < 1)
            throw new IllegalArgumentException();
            // Base Cases
        else if (n == 1)
        {
            return n + "";
        }
        else if (n == 2)
        {
            return (n-1) + " " + (n-1);
        }
        // Recursive Case
        else if (n % 2 == 0)
        {
            total += (a-1) + " " + writeSequence(b) + " " + (a-1);
        }
        else
        {
            total += (a) + " " + writeSequence(b) + " " + (a);
        }

        return total;
    }

    */

    //Returns a string od stars (asterisks) 2^n long.
    public static String starString(int n)
    {
        // Error Case
        if (n < 0)
        {
            throw new IllegalArgumentException();
        }
        // Base Case
        else if (n == 0)
        {
            return "*";
        }
        // Recursive Case
        else
        {
            return starString(n-1) + starString(n - 1);
        }
    }


    public static void printNums(int n)
    {
        // Error Case
        if (n < 0)
        {
            throw new IllegalArgumentException("n should be > 0");
        }

        //Stopping Case
        if (n >= 1)
        {
            //Recursive Case
            System.out.print(n + " ");
            printNums(n-1);

        }

    }

    public static void printNumsAscending(int n)
    {
        // Error Case
        if (n < 0)
        {
            throw new IllegalArgumentException("n should be > 0.");
        }

        // Stopping Case
        if (n >= 1)
        {
            //Recursive Case
            printNumsAscending(n-1);
            System.out.print(n + " ");

        }
    }

    public static double harmonicSeries(int n)
    {
        // 1/2 + 1/1
        // 1/n + 1/n-1
        // Had trouble figuring out the equation.
        // Thought it was 1/harmonicSeries(n-1) + 1/n
        // It was just harmonicSeries(n-1) + 1/n

        // Error Case
        if (n < 0)
        {
            throw new IllegalArgumentException("n should be >= 0.");
        }

        // Stopping Case
        if (n == 0)
        {
            return 0.0;
        }

        //Recursive Case
        return harmonicSeries(n-1) + (1.0/n);

    }

    public static double productOfEvens(int n)
    {

        // Counting evens.
        // If n % 2 = 0 then even
        // If n % 2 = 1 then odd

        /*int count = 4;
        int total = 1;

        for (int i = 0; i < count; i++) {
            int evenNum = (i+1)*2;
            total *= evenNum;
        }*/

        //Error Case
        if (n <= 0)
        {
            throw new IllegalArgumentException("n should be > 0.");
        }

        //Stopping Case
        if (n == 1)
        {
            return 2;
        }

        //Recursive Case
        return n*2 * productOfEvens(n-1);
    }

    public static void funkyHeader(int n)
    {
        // funkyHeader(8) = "<" + funkyHeader(6) + ">"
        // funkyHeader(7) = "<" + funkyHeader(5) + ">"
        // This means that funkyHeader is just wrapping around
        // the funkyHeader(n-2) starting from either n = 1 or 2.
        // A normal case does not hit error case because the program stops
        // once it reaches the base cases 1 or 2.

        // Error Case
        if (n < 1)
            throw new IllegalArgumentException("n should be > 1.");
        // Base/Stopping Cases
        else if (n == 1)
            System.out.print("*");
        else if (n == 2)
            System.out.print("**");

        //Recursive Case
        else {
            System.out.print("<");
            funkyHeader(n-2);
            System.out.print(">");
        }
    }

    public static int countNumbersOf(int value, int[] array)
    {
        /*int times = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] == value)
            {
                times++;
            }
        }

        return times;*/

        return countNumbersOf(0, value, array);
    }

    private static int countNumbersOf (int i, int value, int[] array)
    {
        // Error Case
        if (i < 0 || i > array.length)
            throw new IllegalArgumentException("i has to be > 0 or < length of array.");
        // Base Case
        else if (i == array.length)
        {
            return 0;
        }
        else
        {
            //Recursive Case
            if (array[i] == value)
            {
                return 1 + countNumbersOf(i+1, value, array);
            }
            else
                return countNumbersOf(i+1, value, array);

        }

    }

    public static int howManyDigitsMatch(int n1, int n2)
    {
        // Error Case
        if(n1 < 0 || n2 < 0)
            throw new IllegalArgumentException("Both parameter should be > 0.");
        // Stopping Case
        if (n1 > 0 || n2 > 0)
        {
            // Recursive Cases
            if (n1%10==n2%10)
            {
                return 1 + howManyDigitsMatch(n1/10,n2/10);
            }
            else
            {
                return howManyDigitsMatch(n1/10, n2/10);
            }
        }
        else
            return 0;

    }
}
