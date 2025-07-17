/*
 * Runs multiple cryptosystems
 *
 * @author James Rankin
 * @version 1.0
 * @since July 17 2025
 */

// Import Scanner for inputs
import java.util.Scanner;

// Enum Class to store all the cryptosystems
enum Cryptosystem {
	CAESAR,
	SHIFT;
}

// Cryptosystem Class
class CryptosystemsManager {
	
	public static void main(String[] args) {
		// Check args and run needed function.
		switch(args[0]) {
			case "-e": 
			case "-encryption":
				encrypt(args);
				break;
			case "-d":
			case "-decrypt":
				decrypt(args);
				break;
			default:
				System.out.println("Argument not recognized");
				break;
		}
	}

	// Handles the encrypting of cryptosystems
	private static void encrypt(String[] args) {
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
				// User included plaintext in args
				if (args.length > 2) {
					shift_cipher(true, 3, args[2]);
				}
				// Ask user for plaintext
				else {
					shift_cipher(true, 3, input_to_string(c));
				}
				break;
			case SHIFT:
				// User included shift amount in args
				if (args.length > 2) {
					// Plaintext included in args
					if (args.length > 3) {
						shift_cipher(true, Integer.parseInt(args[2]), args[3]);
					}
					// Ask user for plaintext
					else {
						shift_cipher(true, Integer.parseInt(args[2]), input_to_string(c));
					}
				}
				// Ask user for shift amount and plaintext
				else {
					System.out.print("Amount to shift by: ");
					int shift_amount = c.nextInt();
					shift_cipher(true, shift_amount, input_to_string(c));
				}	
				break;
			default:
				break;
		}
		c.close();
	}

	// Handles the decryption of cryptosystems
	private static void decrypt(String[] args) {

	}
	
	// Helper function for determining which Enum matches a given string.
	private static Cryptosystem str_to_sys(String str) {
		for (Cryptosystem c_sys : Cryptosystem.values()) {
			if (c_sys.name().equals(str)) {
				return c_sys;
			}
		}
		return null;
	}

	// Helper function to get text input from user
	private static String input_to_string(Scanner c) {
		System.out.print("Text to encrypt: ");
                String input = "";
		while (c.hasNext()) {
			input += c.nextLine();
			if (input.length() > 0) 
				break;
		}
		return input;
	}

	// Function for running a shift cipher
	private static void shift_cipher(boolean encrypt, int shift, String plaintext) {
		// If we are encrypting
		if (encrypt) {
			String ciphertext = "";
			for (int i = 0; i < plaintext.length(); i++) {
				char curr = (char)(plaintext.charAt(i) + shift);
				ciphertext += curr;
			}
			System.out.println("Ciphertext: " + ciphertext);
		}
		// If we are decrypting
		else {

		}
	}	
}
