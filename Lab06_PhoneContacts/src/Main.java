import java.io.*;
import java.util.Scanner;

public class Main {

	//Make a constant to represent the binary file
	public static final File BINARY_FILE = new File("contacts.dat");

	public static void main(String[] args) throws InterruptedException {
		
		Scanner keyboard = new Scanner(System.in);
		Contact[] myContacts = new Contact[100];
		int count = 0, choice;
		String firstName, lastName, mobile, birthday;
		boolean isFavorite;

		// Binary File - Allows us to save data persistently in Java
		// 1. When app loads, read data form binary file into an array.

		System.out.println("Loading Contact Information from Database...");
		// DONE: Load contacts from binary file
		// Check to see if we have any data to load:
		if (BINARY_FILE.exists() && BINARY_FILE.length() >= 5) //If the file exists and has more than 5kb of data.
		{
			try
			{
				ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE));
				// Reads an array of Contacts from binary file AND stores it in array named myContacts
				myContacts = (Contact[]) fileReader.readObject();
				// Figure out how many contacts were loaded
				// Loop through the array until we hit a null
				for (int i = 0; i < myContacts.length; i++) {
					if (myContacts[i] == null)
						break;
					count++;
				}
				// Close the file reader!
				fileReader.close();
			}
			catch (FileNotFoundException e)
			{
				System.err.println("Contacts. dat could not be found or accessed.");
			}
			catch (IOException | ClassNotFoundException e)
			{
				System.err.println("File can not be read.");
				System.exit(0);
			}
		}

		System.out.println("Done! " + count + " contacts loaded");

		// 2. Allow user to input new data (new contacts)
		do {
			System.out.print(
				  "\n********************************************************************\n"
				+ "**                                                                **\n"
				+ "**                        AB'S PHONE CONTACTS                     **\n"
				+ "**                                                                **\n"
				+ "********************************************************************\n"
				+ "1) Add New Contact...\n"
				+ "2) View Contact Names\n"
				+ "3) View Contact Details\n"
				+ "4) Exit\n"
				+ "********************************************************************\n"
				+ ">> ");
			choice = keyboard.nextInt();

			switch (choice)
			{
				case 1:  // Add New Contact...
					// Clear out \n from keyboard
					keyboard.nextLine();
					System.out.print("First Name: ");
					firstName = keyboard.nextLine();
					System.out.print("Last  Name: ");
					lastName = keyboard.nextLine();
					System.out.print("Mobile   #: ");
					mobile = keyboard.nextLine();
					System.out.print("Birthday  : ");
					birthday = keyboard.nextLine();
					System.out.print("Favorite (Y/N): ");
					isFavorite = keyboard.nextLine().equalsIgnoreCase("Y");

					// DONE: Instantiate new Contact, add it to the array;
					myContacts[count++] = new Contact(firstName, lastName, mobile, birthday, isFavorite);


					break;

				case 2:  // View Contact Names
					System.out.println("\n********************************************************************");
					System.out.println("                        Contact Names");
					System.out.println("********************************************************************");
					// DONE: Print contact names (only)
					for (int i = 0; i < count; i++) {
						System.out.println(myContacts[i].getFullName());
					}


					break;

				case 3:  // View Contact Details
					System.out.println("\n********************************************************************");
					System.out.println("                        Contact Details");
					System.out.println("********************************************************************");
					// DONE: Print contact details
					for (int i = 0; i < count; i++) {
						System.out.println(myContacts[i]);
					}
				
					break;
				
				case 4:  // Exit
					System.out.println("Saving Contact Information to Database...");
					break;
				default:  // Error - Invalid input
					System.err.println("Invalid choice. Please select (1-4)");
					Thread.sleep(500); // To pause a bit of time (e.g. 0.5 second) before restarting loop

			}
		
		}
		while (choice != 4);

		// 3. Save array (data) to the binary file
		// DONE: Save contacts to binary file
		try
		{
			ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE));
			fileWriter.writeObject(myContacts);
			// Close the file.
			fileWriter.close();
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
		}
		System.out.println("Done! " + count + " contacts saved");
		
		keyboard.close();
	}

}
