# cryptography
## Manual
- To run the project, compile the package run this in the commandline `javac Cryptosystems/*.java`
- All of the cryptosystems can be run from the command line when calling the `Cryptosystems.CryptosystemsManager`
    * The Caesar Cipher can be called to encrypt as follows: `java Cryptosystems.CryptosystemsManager -e CAESAR "Plaintext"`
    * Or to decrypt as follows: `java Cryptosystems.CryptosystemsManager -d CAESAR "Ciphertext"`
    * The Shift Cipher can be called to encrypt as follows: `java Cryptosystems.CryptosystemsManager -e SHIFT (SHIFT AMOUNT) "Plaintext"`
    * Or to decrypt as follows: `java Cryptosystems.CryptosystemsManager -d SHIFT (SHIFT AMOUNT) "Ciphertext"`

