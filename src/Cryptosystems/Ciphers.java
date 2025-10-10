/**
 *
 *
 *
 */

package Cryptosystems;

public class Ciphers {

	/**
	 *
	 */
	public static String substitution(String alphabet, String text) {
		StringBuilder return_text = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char curr = text.charAt(i);
			if (Character.isLetter(curr)) {
				return_text.append(Character.isUpperCase(curr) ? 
								Character.toUpperCase(alphabet.charAt(Character.getNumericValue(curr) - 10)) : 
								Character.toLowerCase(alphabet.charAt(Character.getNumericValue(curr) - 10)));
			}
			else return_text.append(curr);
		}
		return return_text.toString();
	}

	/**
	 *
	 */
	public static String vigenere(int[] shifts, String text) {
		int count = 0;
		StringBuilder return_text = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char curr = text.charAt(i);
			if (Character.isLetter(text.charAt(i))) {
				if (Character.isUpperCase(curr)) { // Handle Uppercase bounds
					curr = (char)(curr + shifts[count]); // Apply Shift to only letters
					if (curr < 'A') curr = (char)(curr + 26);
					else if (curr > 'Z') curr = (char)(curr - 26);
				}
				else { // Handle Lowercase bounds
					curr = (char)(curr + shifts[count]); // Apply Shift to only letters
					if (curr < 'a') curr = (char)(curr + 26);
					else if (curr > 'z') curr = (char)(curr - 26);
				}
				return_text.append(curr);
				if (++count == shifts.length) count = 0;
			}
			else return_text.append(text.charAt(i));	
		}
		return return_text.toString();
	}

	/**
	 *
	 */
	public static String shift_cipher(int shift, String plaintext) {
		StringBuilder ciphertext = new StringBuilder();
		shift %= 26;
		for (int i = 0; i < plaintext.length(); i++) {
			char curr = plaintext.charAt(i); // Apply shift
			if (Character.isLetter(curr)) {
				if (Character.isUpperCase(curr)) { // Handle Uppercase bounds
					curr = (char)(curr + shift); // Apply Shift to only letters
					if (curr < 'A') curr = (char)(curr + 26);
					else if (curr > 'Z') curr = (char)(curr - 26);
				}
				else { // Handle Lowercase bounds
					curr = (char)(curr + shift); // Apply Shift to only letters
					if (curr < 'a') curr = (char)(curr + 26);
					else if (curr > 'z') curr = (char)(curr - 26);
				}
			}
			ciphertext.append(curr);
		}
		return ciphertext.toString();
	}
}
