/**
 * Runs multiple cryptosystems
 *
 * @author James Rankin
 * @version 1.0
 * @since July 17 2025
 */

package Cryptosystems;

// Import Scanner for inputs
import java.util.Scanner;

// Enum Class to store all the cryptosystems
enum Cryptosystem {
	CAESAR,
	SHIFT,
	VIGENERE;
}

// Cryptosystem Class
class CryptosystemsManager {
	
	public static void main(String[] args) {

	}

	private static select

	// Handles the encrypting of cryptosystems
	private static void crypt(String[] args, boolean decrypt) {
		// Modifier to keep track of encrypt/decrypt
		int modifier = 1;
		if (decrypt) modifier = -1;
		Scanner c = new Scanner(System.in);
		Cryptosystem c_sys;
		// If user gives us the system in args
		if (args.length > 1)
			c_sys = str_to_sys(args[1]);
		// If they leave args blank, prompt user and show them which systems we have
		else {
			System.out.println("Which Cryptosystem would you like to run?");
			int i = 1;
			for (Cryptosystem curr_c_sys : Cryptosystem.values()) {
				System.out.println(i++ + " ~ " + curr_c_sys);
			}
			// User inputs number of system
			if (c.hasNextInt()) {
				i = c.nextInt() - 1;
				c_sys = Cryptosystem.values()[i];
			}
			// User inputs name of system
			else {
				c_sys = str_to_sys(c.next().toUpperCase());
			}	
		}
		// Run function for matching system selected
		switch(c_sys) {
			case CAESAR:
				// User included text in args
				if (args.length > 2) {
					System.out.println(Ciphers.shift_cipher(3 * modifier, args[2]));
				}
				// Ask user for text
				else {
					System.out.print("Text to encrypt: ");
					System.out.println(Ciphers.shift_cipher(3 * modifier, input_to_string(c)));
				}
				break;
			case SHIFT:
				// User included shift amount in args
				if (args.length > 2) {
					// Text included in args
					if (args.length > 3) {
						System.out.println(Ciphers.shift_cipher(Integer.parseInt(args[2]) * modifier, args[3]));
					}
					// Ask user for text
					else {
						System.out.print("Text to encrypt: ");
						System.out.println(Ciphers.shift_cipher(Integer.parseInt(args[2]) * modifier, input_to_string(c)));
					}
				}
				// Ask user for shift amount and text
				else {
					System.out.print("Amount to shift by: ");
					int shift_amount = c.nextInt();
					System.out.print("Text to encrypt: ");
					System.out.println(Ciphers.shift_cipher(shift_amount * modifier, input_to_string(c)));
				}	
				break;
			case VIGENERE:
				int[] shifts;
				// Check if user entered a shift list
				if (args.length > 2) {
						String[] str_shifts = args[1].split(","); // Split input text at each comma
                     	// Update int array
                     	shifts = new int[str_shifts.length];
                     	for (int i = 0; i < str_shifts.length; i++) {
                        	shifts[i] = Integer.parseInt(str_shifts[i]) * modifier;
						}
						// Text included in args
						if (args.length > 3) {
							System.out.println(Ciphers.vigenere(shifts, args[2]));	
						}
						// Ask user for text
						else {
							System.out.print("Text to encrypt: ");
		                    System.out.println(Ciphers.vigenere(shifts, input_to_string(c)));
						}
				}
				// Ask user for shift list and text
				else {
					System.out.print("Give list to shift each character by seperated by a comma: ");
					String shift_list = input_to_string(c).trim().replaceAll("\\s",""); // Grab and format input
					String[] str_shifts = shift_list.split(","); // Split input text at each comma
					// Update int array 
					shifts = new int[str_shifts.length];
					for (int i = 0; i < str_shifts.length; i++) {
						shifts[i] = Integer.parseInt(str_shifts[i]) * modifier;
					}
					// Get text
					System.out.print("Text to encrypt: ");
                    System.out.println(Ciphers.vigenere(shifts, input_to_string(c)));
				}
				break;
			default:
				break;
		}
		c.close();
	}  
	
	// Helper function for determining which Enum matches a given string.
	private static Cryptosystem str_to_sys(String str) {
		for (Cryptosystem c_sys : Cryptosystem.values()) {
			if (c_sys.name().equals(str)) return c_sys;
		}
		return null;
	}

	// Helper function to get text input from user
	private static String input_to_string(Scanner c) {
		//System.out.print("Text to encrypt: "); 
        String input = "";
		while (c.hasNext()) {
			input += c.nextLine();
			if (input.length() > 0) break;
		}
		return input;
	}	
}
