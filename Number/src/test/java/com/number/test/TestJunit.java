package com.number.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.number.utils.EncryptString;

public class TestJunit {
	@Test
	public void testAdd() {

		String password = "password";
		String encryptedString = EncryptString.encryptToSHA1(password);

		assertEquals(EncryptString.encryptToSHA1(password), encryptedString);
		assertEquals(40, encryptedString.length());

	}
}