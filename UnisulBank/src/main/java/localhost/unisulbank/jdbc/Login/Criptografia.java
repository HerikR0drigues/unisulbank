/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localhost.unisulbank.jdbc.Login;

import org.jasypt.util.text.StrongTextEncryptor;

/**
 *
 * @author 1072222792
 */
public class Criptografia {
    String password = "unisul";
    StrongTextEncryptor  passwordEncryptor = new StrongTextEncryptor();
    
    public Criptografia() {
        passwordEncryptor.setPassword(password);
    }
    
    public String encriptar(String senha){             
        String encrypted = passwordEncryptor.encrypt(senha);
        return encrypted;
    }
    
    public String desencriptar(String senha){
        String decrypted = passwordEncryptor.decrypt(senha);
        return decrypted;
    }    
}
