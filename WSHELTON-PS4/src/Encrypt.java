/************************************************************
* name William Shelton
* user uafs415
* date 5 November 2021
* assign Problem Set 5
************************************************************/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author William Shelton
 */
public class Encrypt {
    
    public String encryptString(String valueToEncrypt) {
		StringBuffer output = new StringBuffer();

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(valueToEncrypt.getBytes(StandardCharsets.UTF_8));


			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);

				if (hex.length() == 1)
					output.append('0');

				output.append(hex);
			}
		} catch(NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}

		return output.toString();
	}
        
}
