import java.util.Scanner;
import almonds.Parse;
import almonds.ParseObject;
import almonds.ParseException;

public class MenuManager {
	public static void main(String args[]) {
		System.out.println("You can type: ");
		System.out.println();
		String help = "\t\"Add\" to add the menu\n\t\"Edit\" to edit an on the menu\n\t\"Remove\" to remove an item from the menu\n\t\"Help\" to get help\n\t\"Quit\" to quit";
		System.out.println(help+"\n");
		Scanner sc = new Scanner(System.in);
		Parse.initialize("oaZEhvpdjUWDQZjG4zr60avFlkH7qg8wpSssnSqQ", "i21rRuoA6dZahGZy10kGLCPIWbVY9ULTrPfSNX3x");
		ParseObject testObject = new ParseObject("TestObject");
		testObject.put("foo", "bar");
		testObject.save();
		boolean exit = false;
		while (!exit) {
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("quit")) {
				System.exit(0);
			} else if (input.equalsIgnoreCase("help")) {
				System.out.println(help);
			} else if (input.equalsIgnoreCase("add")) {
				System.out.println("Enter the name of the item");
				String name = sc.nextLine();
				System.out.println("Enter a description");
				String description = sc.nextLine();
			}
		}
	}
}
