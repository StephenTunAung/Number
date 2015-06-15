/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.number.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stephentunaung
 */
public class EncryptString {

	/**
	 * encryptToSHA1() returns 40 digits of String.
	 * 
	 * @param password
	 *            String
	 * 
	 * @return encryptedString String
	 */
	public static String encryptToSHA1(String password) {

		String encryptedString = "";
		if (password == null) {
			throw new IllegalArgumentException("Invalid Input...");
		}
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			password = "Salt" + password;
			byte[] bytes = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			encryptedString = sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(EncryptString.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return encryptedString;
	}

}