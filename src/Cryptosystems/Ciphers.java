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
	public static String vigenere(int[] shifts, String text) {
		int count = 0;
		StringBuilder ciphertext = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			if (Character.isLetter(text.charAt(i))) {
				ciphertext.append(shift_cipher(shifts[count], text.charAt(i) + ""));
				if (++count == shifts.length) count = 0;
			}
			else ciphertext.append(text.charAt(i));	
		}
		return ciphertext.toString();
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
