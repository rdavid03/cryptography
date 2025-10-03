# Cryptosystems Manager
## Manual
- To run the project in a terminal;
    1. Go into the source directory - `cd src`
    2. Compile the package run this in the commandline `javac Cryptosystems/*.java`
    3. Now we can run the program calling `java Cryptosystems/CryptosystemsManager`
        * This will start the programs menu IO, alternatively the program can be run soley from the command line.
- To run in an IDE; simply compile and run and the program will be interactable through the IDE shell.
- All of the cryptosystems can be run from the command line when calling the `java Cryptosystems.CryptosystemsManager {CIPHER_TYPE} {DE/ENCRYPT} {TEXT} {KEY}`.
    * Here are the following `{CIPHER_TYPE}` *(the casing does not matter)* :
        * `CAESAR` or `1` to run the a Caesar Cipher.
        * `SHIFT` or `2` to run a Shift Cipher.
        * `VIGNERE` or `3` to run a Vignere cipher.
    * Here are the options for `{DE/ENCRYPT}` *(the casing does not matter)* :
        * `-encryption`, `-encrypt` or `-e` to run encrypt with a given cipher.
        * `-decryption`, `-decrypt` or `-d` to run decrypt with a given cipher.
    * For `{TEXT}` enter in the given plain or cipher text, if it has spaces surround the text with double quotations.
    * For `{KEY}` it is different for each cipher.
        * `CAESAR` -> no key is needed.
        * `SHIFT` -> a number for the amount to shift by. 
        * `VIGNERE` -> a word that will be used to shift the given text.
