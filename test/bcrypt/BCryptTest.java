/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcrypt;

import org.mindrot.jbcrypt.*;

/**
 *
 * @author Rob
 */
public class BCryptTest {
    public static void main(String[] args){
        String hashed = BCrypt.hashpw("Aa12345!", BCrypt.gensalt());
        System.out.println(hashed);
    }
}
