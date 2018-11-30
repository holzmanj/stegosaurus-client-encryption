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
