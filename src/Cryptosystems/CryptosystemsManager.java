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
	
	public static Scanner c;

	public static void main(String[] args) {
		c = new Scanner(System.in);
		Cryptosystem curr_sys = cipher_select(args.length > 0 ? args[0] : ask_cipher());
		boolean encrypt = encrypting(args.length > 1 ? args[1] : ask_encrypt());
		String text = args.length > 2 ? args[2] : get_text(encrypt);
		text = run_cipher(curr_sys, encrypt, text, (args.length > 3 ? args[3] : get_key(curr_sys)));
		System.out.println((encrypt ? "Ciphertext: " : "Plaintext: ") + text);
		c.close();
	}

	/**
	 *
	 */
	private static Cryptosystem cipher_select(String cipher_str) {
		switch(cipher_str.toUpperCase()) {
				case "CAESAR":
				case "1":
					return Cryptosystem.CAESAR;
				case "SHIFT":
				case "2":
					return Cryptosystem.SHIFT;
				case "VIGENERE":
				case "3":
					return Cryptosystem.VIGENERE;
				default:
					System.out.println("Cipher " + cipher_str + " is not recognized option.");
					return cipher_select(ask_cipher());				
		}
	}

	/**
	 *
	 */
	private static String ask_cipher() {
		System.out.println("Which Cryptosystem would you like to run?");
		int i = 0;
		for (Cryptosystem curr_crysys : Cryptosystem.values()) {
			System.out.println((++i) + " ~ " + curr_crysys); // Print out all cryptosystems
		}
		return c.next();
	}

	/**
	 *
	 */
	private static boolean encrypting(String to_encrypt) {
			switch(to_encrypt.toLowerCase()) {
				case "-encryption":
				case "-encrypt":
				case "-e":
						return true;
				case "-decryption":
				case "-decrypt":
				case "-d":
						return false;
				default:
						System.out.println("Selection \"" + to_encrypt + "\" unclear, please try again.");
						return encrypting(ask_encrypt());
			}
	}

	/**
	 *
	 */
	private static String ask_encrypt() {
		System.out.print("Encrypt (e) or Decrypt (d): ");
		return "-" + c.next();
	}

	/**
	 *
	 */
	private static String get_text(boolean plaintext) {
		if (plaintext) System.out.print("Enter plaintext: ");
		else System.out.print("Enter Ciphertext: ");
		return input_to_string();
	}

	/**
	 *
	 */
	private static String get_key(Cryptosystem sys) {
			switch(sys) {
				case CAESAR:
						return "3";
				case SHIFT:
						System.out.print("Amount to shift by: ");
						return c.next();
				case VIGENERE:
						System.out.print("Enter keyword: ");
						return c.next();
				default :
						System.out.println("Error handling here TODO");
						return "";
			}
	}

	/**
	 *
	 */
	private static String run_cipher(Cryptosystem sys, boolean encrypt, String text, String key ) {
		switch (sys) {
			case CAESAR:
			case SHIFT:
					return Ciphers.shift_cipher((encrypt ? 1 : -1) * Integer.parseInt(key), text);
			case VIGENERE:
					return Ciphers.vigenere(string_to_arr(key, encrypt), text);					
			default:	
					System.out.println("cipher: " + sys + "\tencrypt: " + encrypt + "\ttext: \"" + text + "\"\tkey: " + key);
					break;
		}
		return "";
	}

	/**
	 *
	 */
	private static String input_to_string() {
        String input = "";
		while (c.hasNext()) {
			input += c.nextLine();
			if (input.length() > 0) break;
		}
		return input;
	}

	/**
	 *
	 */
	private static int[] string_to_arr(String key, boolean encrypt) {
        int multiplier = encrypt ? 1 : -1;
        int[] arr = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            char curr_val = Character.toUpperCase(key.charAt(i));
            if (Character.isLetter(curr_val)) {
                arr[i] = (Character.getNumericValue(curr_val) - 10) * multiplier;
            }
        }
        return arr;
    }	
}
