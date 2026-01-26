public class Main
{
    public static void main(String[] args)
    {
        /*
        // Ctrl + D = To duplicate a line of code quickly
        System.out.println("Hello world!");

        //sout = System.out.println
        System.out.println("WoW!");
        
        //fori

        for (int i = 0; i < 10; i++) {
            System.out.println(" i is: " + i);
        }

        // Shift + F10 to run
        */

        System.out.println("\n~~~Game Characters Created~~~");

        //Instantiate 3 New Objects
        GameCharacter aberham = new GameCharacter("Aberham", 100);
        GameCharacter masterChief = new GameCharacter("Master Chief", 20);
        GameCharacter floodling = new GameCharacter("Flood", 10);

        //Print out each character (using toString)

        System.out.println(aberham.toString());
        System.out.println(masterChief);
        System.out.println(floodling);

        System.out.println("\n~~~Aberham is assisting Master Chief!~~~");
        aberham.assist(masterChief);
        System.out.println(masterChief);
        System.out.println(aberham);

        System.out.println("\n~~~Master Chief is attacking the Flood~~~");
        masterChief.attack(floodling);
        System.out.println(floodling);

        masterChief.rest();
        aberham.rest();
        System.out.println("\n~~~Aberham and Master Chief have rested~~~");
        System.out.println(aberham.toString());
        System.out.println(masterChief);
        System.out.println("\n~~~Aberham and Master Chief have killed the Flood~~~");


    }
}