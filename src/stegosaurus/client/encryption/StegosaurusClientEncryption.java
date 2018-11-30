/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stegosaurus.client.encryption;

import java.io.File;

/**
 *
 * @author jesse
 */
public class StegosaurusClientEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		/**
		 * HOW TO USE
		 * ==========
		 * All functions in EncryptionUtils are static, so you don't
		 * need to create an object to use them. Simply call them from
		 * the EncryptionUtils class itself (see below).
		 *
		 * generateKeys returns an array of two strings: the first one
		 * (position 0 in the array) is the client key, and the second
		 * one (position 1 in the array) is the server key.
		 * Use the client key for encrypting and decrypting the
		 * content file, and send the server key to the API the the
		 * "key" parameter.
		 *
		 * encrypt takes a key (the client key string) and two file
		 * objects. The first one is the input file that is read from
		 * (this should be your unencrypted content file) and the
		 * second one should be a new empty file where the encrypted
		 * data is written.
		 *
		 * decrypt similarly takes a key and two file objects. The
		 * key again needs to be the client key you encrypted the
		 * file with. The first file object should be the encrypted
		 * content file. The second file object should be a new empty
		 * file where the decrypted contents of the input file are 
		 * written.
		 * 
		 * For the encrypt and decrypt functions, try to avoid using
		 * the same file object for the input and output files if you
		 * can (it might cause some errors somewhere otherwise).
		 *
		 */
        String keys[] = EncryptionUtils.generateKeys("stegosaurus");
        String clientKey = keys[0];
        String serverKey = keys[1];
        
        File plaintext = new File("res/Applied_Cryptography.pdf");
        File ciphertext = new File("res/encrypted");
        
        try {
            EncryptionUtils.encrypt(clientKey, plaintext, ciphertext);
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
        
        File output = new File("res/decrypted");
        
        try {
            EncryptionUtils.decrypt(clientKey, ciphertext, output);
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
        
    }
    
}
